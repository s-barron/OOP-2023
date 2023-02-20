package ie.tudublin;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList; 

public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		
		smooth();

		loadStars();
		printStars();
	}

	public void drawGrid()
	{
		stroke(0, 255, 255);
		float border = width * 0.1f;

		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = map(i, -5, 5, border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			textAlign(CENTER, CENTER);
			text(i, x, border * 0.5f);
			text(i, border * 0.5f, x);
		}

		//float f = map(5, 0, 10, 100, 200);
		//float f1 = map1(5, 0, 10, 100, 200);
		
	}

	public void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
		ArrayList<Star> stars = new ArrayList<Star>();
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
			stars.add(s);
 		}
 	}

	public class Star {

		private boolean hab;
		private String displayName;
		private float distance;
		private float xG;
		private float yG;
		private float zG;
		private float absMag;

		public Star(TableRow tr)
 		{
			this(
				tr.getInt("Hab?") == 1, 
				tr.getString("Display Name"), 
				tr.getFloat("Distance"),
				tr.getFloat("Xg"),
				tr.getFloat("Yg"),
				tr.getFloat("Zg"),
				tr.getFloat("AbsMag")
			);
		}
		
		public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
			this.hab = hab;
			this.displayName = displayName;
			this.distance = distance;
			this.xG = xG;
			this.yG = yG;
			this.zG = zG;
			this.absMag = absMag;
		}	
	
	}
			
	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
		displayStars();
	}
}
