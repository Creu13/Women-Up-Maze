//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Draw Maze 

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class MazeMap {
	private Maze maze;

	//constructor
	public MazeMap() {
		maze = new Maze();
		Color c = Color.black;

		//walls in Maze2
		maze.addWall(100, 100, 10, 600, c);
		maze.addWall(100, 100, 600, 10, c);
		maze.addWall(100, 700, 600, 10, c);
		maze.addWall(700, 100, 10, 610, c);

		//horizontal walls
		maze.addWall(200, 200, 400, 10, c);
		maze.addWall(200, 300, 100, 10, c);
		maze.addWall(400, 300, 100, 10, c);
		maze.addWall(200, 400, 200, 10, c);
		maze.addWall(500, 400, 100, 10, c);
		maze.addWall(200, 500, 100, 10, c);
		maze.addWall(100, 600, 200, 10, c);
		maze.addWall(500, 600, 100, 10, c);

		//vertical walls
		maze.addWall(300, 500, 10, 110, c);
		maze.addWall(400, 300, 10, 300, c);
		maze.addWall(600, 200, 10, 210, c);
		maze.addWall(600, 500, 10, 110, c);
		maze.addWall(500, 400, 10, 200, c);

		//obstacles
		maze.addObstacles(200, 230, 50, 50);
		maze.addObstacles(200, 430, 50, 50);
		maze.addObstacles(630, 220, 50, 50);

	}
	//get walls in MazeMap2
	public ArrayList<Wall> getWalls()
	{
		return maze.getWalls();
	}
	//get obstacles in MazeMap2
	public ArrayList<Obstacles> getObstacles()
	{
		return maze.getObstacles();
	}
	//draws obstacles and walls
	public void draw(Graphics g) {
		maze.drawWalls(g);
		maze.drawObstacles(g);
	}
}
