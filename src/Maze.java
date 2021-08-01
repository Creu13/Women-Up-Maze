//Author: Mira, Sreya, Sruthi
//Date: 07/01/2021
//Rev: 05
//Note: Puts all of the walls added from mazemap into arraylist

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Maze{
	private ArrayList<Wall> walls;
	private ArrayList<Obstacles> obstacles;

	//constructor
	public Maze()
	{
		walls = new ArrayList<Wall>();
		obstacles = new ArrayList<Obstacles>();
	}


	//Walls
	public void addWall(int x, int y, int width, int height, Color color)
	{
		Wall newWall = new Wall(x, y, width, height, color);
		walls.add(newWall);
	}

	public ArrayList<Wall> getWalls()
	{
		return walls;
	}

	public void drawWalls(Graphics pen)
	{
		for(Wall wall: walls)
		{
			wall.draw(pen);
		}
	}


	//Obstacles
	public void addObstacles(int x, int y, int width, int height) 
	{
		Obstacles newObstacles = new Obstacles(x, y, width, height, Color.red);
		obstacles.add(newObstacles);
	}

	public ArrayList<Obstacles> getObstacles() 
	{
		return obstacles;
	}

	public void drawObstacles(Graphics pen) 
	{
		for(Obstacles obstacle: obstacles)
		{
			obstacle.draw(pen);
		}
	}


}
