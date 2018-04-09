package frontend;

import javax.swing.*;
import java.awt.*;

public class Executable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 600;
		int height = 250;
		
		JFrame f = new ProjectFrame(width, height);
        f.getContentPane().setPreferredSize(new Dimension(width,height));
        f.pack();
        f.setTitle("CS 124 Project");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}

}
