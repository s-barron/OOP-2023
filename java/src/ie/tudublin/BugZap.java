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

		bugX = width/2;
		bugY = 15;
		bugHeight = 10;

		smooth();
		
	}
	float playerX, playerY, playerWidth;
	float bugX, bugY, bugHeight;
	int score;

	public void drawPlayer(float x, float y, float w)
	{
		strokeWeight(2);
		stroke(255);
		float h = w/2;
		rect(x,y,w,h);
		
	}
	public void drawBug(float x, float y, float h)
	{
		strokeWeight(2);
		stroke(255);
		triangle(x, y, x-(h/2), y-h, x+(h/2),y-h);
		
		
	}	
	
	public void draw()
	{	
		background(0);
		if((frameCount % 60) == 0)
		{
			bugX = random(0,500);
			bugY += 10;
		}
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugHeight);
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
			if(playerX > 0)
			{
				playerX--;
			}
			else
			{
				playerX += 10;
			}
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
			if(playerX < width)
			{
				playerX++;
			}
			else
			{
				playerX -= 10;
			}
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			line(playerX+playerWidth/2,playerY, playerX+playerWidth/2, 0);
			float zapper = playerX+playerWidth/2;
			if(zapper > bugX-(bugHeight/2) && zapper < bugX+(bugHeight/2))
			{
				score++;
			}
		}

	}
		
}
