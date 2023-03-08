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
		board = new LifeBoard(50, this);
		board.randomise();
	}

	int mode = 0;

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		switch(mode)
		{
			case 1:
			{
				board.randomise();	
				break;
			}
			case 2:
			{
				for(int row = 0; row < 50; row++)
				{
					for(int col = 0; col < 50; col++)
					{
						board.board[row][col] = false;
					}
				}
				break;
			}
		}
			
	}

	public void draw()
	{	
		background(0);
		board.render();
		board.applyRules();
		
	}
}
