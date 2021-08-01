//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Treasure/ final goal class

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Treasure extends JPanel{
	private Image Treasure;
	private int TreasureX = 620, TreasureY = 120;

	//constructor
	public Treasure() {
		super();
		Treasure = (new ImageIcon("TreasureComp.png")).getImage();
	}
	//draws cheese at end of maze
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Treasure, TreasureX, TreasureY, 60, 60, this);
	}

	public int getCheeseX() {
		return TreasureX;
	}

	public int getCheeseY() {
		return TreasureY;
	}

	//returns bounds of cheese used in is colliding method
	public Rectangle getBounds() {
		Rectangle rect = new Rectangle(TreasureX, TreasureY, 60, 60);
		return rect;
	}
}
