//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Character 

import java.awt.* ;
import javax.swing.*;
import java.awt.Graphics2D;


public class Character extends JPanel{

	private Image mouseRun, mouseJump;
	private int mouseX = 120, mouseY = 620;
	private boolean previousJump = false, doJump = false;

	//constructor
	public Character() {
		super();
		mouseRun = (new ImageIcon("walking_adobespark.png")).getImage();
		mouseJump = (new ImageIcon("Jumping_adobespark.png")).getImage();
		
	}
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		if (doJump == true) {
			g2.drawImage(mouseJump, mouseX, mouseY, 60, 50, this);
		}

		else 
			g2.drawImage(mouseRun, mouseX, mouseY, 40, 50, this);
	}

	public void moveLeft() {
		mouseX -= 10;
	}


	public void moveRight() {

		mouseX += 10;
	}


	public void moveUp() {

		mouseY -= 10; 
	}


	public void moveDown() {

		mouseY += 10;
	}

	public void jump() {

		doJump = true;
		if (previousJump == false) {
			mouseX += 40;
			mouseY -= 10; }
		previousJump = true;
	}

	public void jumpDone() {

		doJump = false;
		mouseY += 10;
		previousJump = false;
	}
	//moves mouse to the start of maze game
	public void restart()
	{
		mouseX = 120;
		mouseY = 620;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
	//Used for isColliding() method
	public Rectangle getBounds() {
		Rectangle rect = new Rectangle(mouseX, mouseY, 90, 45);
		return rect;
	}
	public double scale() {
		return 0.25;
	}

}