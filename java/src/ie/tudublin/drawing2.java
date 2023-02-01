package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);
	}

	//255 is the max value for 8 bits: 2^8
	
	public void draw()
	{	
		stroke(255); // you can use 1 parameter or 3
		line(10,10,100,100); //(x1,y1,x2,y2)
		circle(300,250,70);  //(cx, cy, di)
		fill(0,255,0);
		rect(10,300,20,100); //(tlx, tly, width, height)
		stroke(127);
		fill(255,0,255);
		noStroke();
		noFill();
		strokeWeight(1);
		triangle(40,90,300,20,80,70);  

	}
}
