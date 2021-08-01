//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Level 2 window

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class PlayMode extends JPanel implements KeyListener, ActionListener{


	private MazeMap maze2;
	private Character chara;
	private Treasure cheese;
	private CountDown timer;
	private int time;
	boolean jumpSuccess = true;
	Timer clock;
	private Image Fact1;
	private Image Fact2;
	private Image Fact3;


	//constructor
	public PlayMode() {
		maze2 = new MazeMap();
		chara = new Character();
		cheese = new Treasure();
		timer = new CountDown();
		time = 0;
		clock = new Timer(1000, this); 
		clock.start();
		Fact1 = (new ImageIcon("Fact1.png")).getImage();
		Fact2 = (new ImageIcon("Fact2.png")).getImage();
		Fact3 = (new ImageIcon("Fact3.png")).getImage();
//		Fact1 = (new ImageIcon("Door.jpeg")).getImage();
//		Fact2 = (new ImageIcon("Door.jpeg")).getImage();
//		Fact3 = (new ImageIcon("Door.jpeg")).getImage();
	}

	//Draws maze and character
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 

		maze2.draw(g);
		chara.draw(g);
		cheese.draw(g);
		timer.draw(g);
	}

	//arrow keys for character movement
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			chara.moveLeft();

			if(isCollidingWall())
			{
				chara.moveRight();
			} 
			if(isCollidingObstacle())
			{
				chara.restart();
			}
			if(reachGoal())
			{
				endGame();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			chara.moveRight();

			if(isCollidingWall())
			{
				chara.moveLeft();
			}
			if(isCollidingObstacle())
			{
				chara.restart();
			}
			if(reachGoal())
			{
				endGame();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			chara.moveUp();

			if(isCollidingWall())
			{
				chara.moveDown();
			}
			if(isCollidingObstacle())
			{
				chara.restart();
			}
			if(reachGoal())
			{
				endGame();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			chara.moveDown();

			if(isCollidingWall())
			{
				chara.moveUp();
			}
			if(isCollidingObstacle())
			{
				chara.restart();
			}
			if(reachGoal())
			{
				endGame();
			}
		} 
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			if(isJumpColliding()!= true)
			{
				chara.jump();
				jumpSuccess = true;
			}
		}
		repaint();
	}
	//used for jump movement
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {			
			if (jumpSuccess) {
				chara.jumpDone();
				jumpSuccess = false;
			}
		}

		repaint();

	}
	//Sets bounds for character and checks if intersecting with bounds of every obstacle
	private boolean isCollidingObstacle() {
		Rectangle rChar = chara.getBounds();

		for(Obstacles obstacle : maze2.getObstacles())
		{
			Rectangle rObstacle = new Rectangle(obstacle.getX(), obstacle.getY());
			if(rChar.intersects(rObstacle))
			{
				return true;
			}
		}
		return false;
	}

	//Sets bounds for character and checks if intersecting with bounds of every wall
	public boolean isCollidingWall() 
	{
		Rectangle rChar = chara.getBounds();
		for(Wall walls : maze2.getWalls())
		{
			Rectangle rWall = new Rectangle(walls.getX(), walls.getY(), walls.getWidth(), walls.getLength());
			if(rChar.intersects(rWall))
			{
				return true;
			}
		}
		return false;
	}
	//Checks if character has enough space to jump
	public boolean isJumpColliding() 
	{
		Rectangle r2 = new Rectangle(chara.getMouseX(), chara.getMouseY()-10, 130, 45 );

		for(Wall walls : maze2.getWalls())
		{
			Rectangle r3 = new Rectangle(walls.getX(), walls.getY(), walls.getWidth(), walls.getLength());
			if(r2.intersects(r3))
			{
				return true;
			}
		}
		return false;
	}

	//checks if character reached cheese 
	public boolean reachGoal()
	{

		Rectangle rChar = chara.getBounds();
		if(rChar.intersects(cheese.getBounds()))
		{
			System.out.println("reached");
			return true;
		}
		return false;
	}

	public void endGame()
	{
		try {
			clock.stop();
			MazeMain menu = new MazeMain();
			menu.endGame(""+ timer.getTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		timer.setTimer();
		repaint();
		if(timer.getTime() == 0)
		{
			endGame();
		}

	}
}

