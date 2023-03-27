package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;
	
	//ArrayList can grow and shrink
	//Generic
	//Can only store classes
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();


	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		for(int i = bullets.size() - 1; i >= 0; i--)
		{
			Bullet b = bullets.get(i);
			b.render();
			b.move();
		}
		//for(Bullet b:bullets) //you can't remove elements from an array with for loop
		//if you remove an element from the middle that means the subsequent element won't get an update in the next frame
		

		fill(255);
		text("Bullets: " + bullets.size(), 50, 50);
	}
}
