package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
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
		background(0);
		//fill(255);
		fill(180,100,100);
		switch(mode)
		{
			case 0:
			{
				if(mouseX > width/4 && mouseX < width/2)
				{					
					rect(width/4,0, width/4, height);
				}
				else if(mouseX > width/2 && mouseX < width*0.75)
				{
					rect(width/2,0, width/4, height);
				}
			}
			case 1:
			{
				
			}


		}
		
		
		

	}
}
