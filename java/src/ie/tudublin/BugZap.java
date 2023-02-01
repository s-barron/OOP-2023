package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		playerX = width/2;
		playerY = height-25;
		playerWidth = 25;

		smooth();
		
	}
	float playerX, playerY, playerWidth;

	public void drawPlayer(float x, float y, float w)
	{
		strokeWeight(2);
		stroke(255);
		float h = w/2;
		rect(x,y,w,h);
		
	}	
	
	public void draw()
	{	

		drawPlayer(playerX, playerY, playerWidth);

	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}
		
}
