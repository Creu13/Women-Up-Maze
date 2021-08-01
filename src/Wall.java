//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: All features of wall object

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Wall {
	int x;
	int y;
	int width;
	int height;
	Color color;

	//constructor
	public Wall() {

	}
	//constructor 2
	public Wall(int x, int y, int width, int height, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = c;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getLength() {
		return this.height;
	}

	public void draw(Graphics pen) {
		pen.setColor(this.color);
		pen.fillRect(this.x, this.y, this.width, this.height);
	}
}
