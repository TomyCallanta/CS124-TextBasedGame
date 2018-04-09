package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ProjectFrame extends JFrame{
	int width, height;
	JScrollPane screenScroll;
	JTextArea screen;
	JTextField inputfield;
	
	public ProjectFrame(int w, int h) {
		width = w;
		height = h;
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		addComponents(c);
		
		addKeyActions();
		
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}
	
	private void addComponents(Container c) {
		screen = new JTextArea();
		screenScroll = new JScrollPane (screen);
		screenScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		c.add(screenScroll, BorderLayout.CENTER);
		screen.setEditable(false);
		
		inputfield = new JTextField();
		c.add(inputfield, BorderLayout.PAGE_END);
	}
	
	Action printText = new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			if(!inputfield.getText().equals("")) {
				screen.append(inputfield.getText() + "\n");
				inputfield.setText("");
			}
		}
	};
	
	private void addKeyActions() {
		inputfield.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "printText");
		inputfield.getActionMap().put("printText", printText);
	}
}
