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

		background(0,0,100);

		for(int i = 0; i < 5; i++)
		{
			int x1 = 250;
			int y1 = 250;
			double x2 = x1 + 100 * (Math.cos((i+1)*108));
			double y2 = y1 + 100 * (Math.sin((i+1)*108));

			line(x1,y1,(float)x2,(float)y2);
		}

		
	}

}