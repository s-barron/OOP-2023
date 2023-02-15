package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB,360,100,100);
		background(0,0,0);
		smooth();
		
	}

	int x,y,w,h;
	public void drawGrid()
	{
		
		x = 0;
		y = 0;
		w = width/11;
		h = height/11;

		for(int i = 0; i < 11; i++)
		{
			
			for(int j = 0; j < 11; j++)
			{
				rect(x,y,w,h);
				x += w;
			}
			x = 0;
			y += h;	
		}

	}
	public void draw()
	{	
		strokeWeight(2);
		stroke(90,100,100);
		drawGrid();	
	}
}
