package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	LifeBoard board;
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(100,this);
		board.randomise();		
		
	}

	
	
	public void draw()
	{	
		noFill();
		stroke(255);
		board.render();
		
		
	}
}
