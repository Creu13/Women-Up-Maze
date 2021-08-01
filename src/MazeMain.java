//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note:
/* Added in the necessary objects (tester + timer) in this main class so everything would run in one program
 * 	^ also added the JFrames in Easy Mode
 * ^^ changed a bit of the location and size of the timer so it would look well in the output
 */
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;

public class MazeMain extends JFrame implements ActionListener {

	JFrame gameWindow = new JFrame("Women's Empowerment Maze!");
	static int windowWidth = 618;
	static int windowHeight = 687;
	JFrame startMenu = new JFrame("Welcome to the Maze");


	Button instructionsButton = new Button("Instructions");
	Button hardButton = new Button("Play!");

	JPanel endGamePanel = new JPanel();
	static int endGamePanelHeight = 50;
	JLabel endGameMessage;
	Button exitButton = new Button("Exit");

	MazeEngine engine = new MazeEngine();
	CountDown t = new CountDown(); //* add var name!

	boolean didInitialSetup = false;



	public MazeMain() throws IOException {    	
		// Create and set up the menu
		startMenu.setPreferredSize(new Dimension(700, 700));
		startMenu.setLocationRelativeTo(null);
		startMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BufferedImage startMenuBackground = ImageIO.read(new File("background.png")); //* SMALL BUG: didn't add the 'Images/'
		JLabel imgLabel = new JLabel(new ImageIcon(startMenuBackground));
		startMenu.add(imgLabel);

		JPanel buttonPanel  = new JPanel();
		// Display the window
		instructionsButton.setSize(200, 100);
		hardButton.setSize(200, 100);
		hardButton.addActionListener(this);
		instructionsButton.addActionListener(this);

		buttonPanel.add(hardButton, BorderLayout.CENTER);
		buttonPanel.add(instructionsButton, BorderLayout.CENTER);
		startMenu.getContentPane().add(buttonPanel, BorderLayout.NORTH);

	}


	//this is where the box is supposed to pop up at the bottom and ask the user if they want to continue.
	public void endGame(String message){

		endGamePanel.removeAll();
		endGamePanel.setPreferredSize(new Dimension(windowWidth, endGamePanelHeight));

		// Setting up the buttons
		exitButton.setSize(20, 10);
		exitButton.addActionListener(this);

		// Creating the end game message
		endGameMessage = new JLabel(message + " seconds left! " + " You have sucessfully created a career in the tech industry! ");

		// Adding the end game message and buttons to the end game panel
		endGamePanel.add(endGameMessage);
		endGamePanel.add(exitButton, BorderLayout.SOUTH);
		gameWindow.getContentPane().add(endGamePanel, BorderLayout.SOUTH);

		gameWindow.pack();

		didInitialSetup = true;

		endGamePanel.setVisible(true);

		gameWindow.setVisible(true);
	}

	// check for button presses
	@Override
	public void actionPerformed(ActionEvent click) {
	 //instructions code for start menu
		if (click.getSource() == instructionsButton) {
			JPanel instructions = new JPanel();
			JLabel line1 = new JLabel("The player uses the 4 arrow keys and spacebar to move the mouse character around the maze");
			JLabel line2 = new JLabel("The objective of the game is to get the woman to the end of the maze where the treasure is");
			JLabel line3 = new JLabel("The woman has a time limit to get through the maze");
			JLabel line4 = new JLabel("The woman can not touch the obstacles in the maze and can only walk the path between the walls");
			JLabel line5 = new JLabel("Use the Arrow Keys to Move. Use the spacebar to jump. ");
			JLabel line6 = new JLabel("Good luck. Have Fun!");


			instructions.add(line1);
			instructions.add(line2);
			instructions.add(line3);
			instructions.add(line4);
			instructions.add(line5);
			instructions.add(line6);

			startMenu.getContentPane().add(instructions, BorderLayout.CENTER);

			startMenu.setVisible(true);
		} else if (click.getSource() == hardButton) {
			JFrame w = new JFrame("Hard Mode");
			w.setBounds(100, 100, 810, 810);
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PlayMode panel = new PlayMode();
			panel.setBackground(Color.PINK);
			w.addKeyListener(panel);
			w.add(panel);
			w.setFocusable(true);
			w.setResizable(true);
			w.setVisible(true);

			startMenu.setVisible(false);

		} else if (click.getSource() == exitButton){
			System.exit(0);
		}
	}

}