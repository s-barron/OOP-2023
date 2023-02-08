package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	int color = 0;
	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB, 360, 100, 100);
	}



	public void keyPressed() {
		
		mode = key - '0';
		println(mode);
	}

	public void draw() {
		noStroke();
		background(0);
		//fill(255);
		for(int i = 0; i < 10; i++)
		{
			fill(color + (i*35),100,100);
			rect(i*(width/10), i*(height/10), width/10, height/10);
		}
	}

}