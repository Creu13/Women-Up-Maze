//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: MazeMain has this so it can run the code.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeEngine extends Canvas {
	static MazeMain window;

	//main method
	public static void main(String[] args) {
		try {
			window = new MazeMain();
			window.setBounds(100, 100, 810, 810);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		window.startMenu.pack();
		window.startMenu.setVisible(true);
		window.startMenu.setResizable(false);

	}

}
