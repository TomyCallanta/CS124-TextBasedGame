package frontend;

import javax.swing.*;

import maze.MazeMaker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ProjectFrame extends JFrame{
	int width, height;
	MazeMaker maze;
	JScrollPane screenScroll;
	JTextArea screen;
	JTextField inputfield;
	
	public ProjectFrame(int w, int h, MazeMaker m) throws Exception {
		width = w;
		height = h;
		maze = m;
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		addComponents(c);
		
		addKeyActions();
		
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        screen.append(maze.load());
	}
	
	private void addComponents(Container c) {
		screen = new JTextArea();
		screen.setEditable(false);
		screen.setLineWrap(true);
		screenScroll = new JScrollPane (screen);
		screenScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		c.add(screenScroll, BorderLayout.CENTER);
		
		inputfield = new JTextField();
		c.add(inputfield, BorderLayout.PAGE_END);
	}
	
	Action printText = new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			String text = inputfield.getText();
			if(!text.equals("")) {
				String[] parsed = text.split(" ");
				if(parsed[0].equals("go"))
				{
					screen.append(maze.move(text));
				}else{
					if(parsed.length > 1)
						screen.append(maze.action(parsed[0], parsed[1]));
					else
						screen.append(maze.action(text, null));
				}
			}
			inputfield.setText("");
			JScrollBar scrollbar = screenScroll.getVerticalScrollBar();
			scrollbar.setValue(scrollbar.getMaximum());
		}
	};
	
	private void addKeyActions() {
		inputfield.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "printText");
		inputfield.getActionMap().put("printText", printText);
	}
}
