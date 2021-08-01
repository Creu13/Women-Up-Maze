//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Obstacles code here
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Obstacles extends JPanel{
	int x;
	int y;
	

	private Image Fact1;
	private Image Fact2;
	private Image Fact3;
	private int FactX1 = 200, FactY1 = 200;
	private int FactX2 = 200, FactY2 = 400;
	private int FactX3 = 600, FactY3 = 200;

	//constructor
	public Obstacles() {
		super();
		Fact1 = (new ImageIcon("Fact1.png")).getImage();
		Fact2 = (new ImageIcon("Fact2.png")).getImage();
		Fact3 = (new ImageIcon("Fact3.png")).getImage();

	}
	//constructor 2
	public Obstacles(int x, int y, int radius, int height, Color c) {
		this.x = x;
		this.y = y;
	
		Fact1 = (new ImageIcon("Fact1.png")).getImage();
		Fact2 = (new ImageIcon("Fact2.png")).getImage();
		Fact3 = (new ImageIcon("Fact3.png")).getImage();

	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}


	public void draw(Graphics pen) {
		
		Graphics2D g2 = (Graphics2D) pen;
		g2.drawImage(Fact1, FactX1, FactY1, 120, 120,this);
		g2.drawImage(Fact2, FactX2, FactY2, 120, 120,this);
		g2.drawImage(Fact3, FactX3, FactY3, 120, 120,this);

	}
}

