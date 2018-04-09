package frontend;

import javax.swing.*;
import java.awt.*;
import maze.MazeMaker;

public class Executable{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int width = 600;
		int height = 250;
		MazeMaker maze = new MazeMaker();
		
		JFrame f = new ProjectFrame(width, height, maze);
        f.getContentPane().setPreferredSize(new Dimension(width,height));
        f.pack();
        f.setTitle("CS 124 Project");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}

}
