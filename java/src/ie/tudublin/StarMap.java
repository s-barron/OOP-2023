package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();

    public void setup()
    {
        colorMode(RGB);
        loadData();
        printStars();
    }

    public void settings()
    {
        size(800,800);
    }

    public void printStars()
    {
        for(Star s: stars)
        {
            System.out.println(s);
        }
    }
    
    public void loadData(){

        Table table;

        table = loadTable("HabHYG15ly.csv","header");

        for(TableRow r: table.rows()) {
            Star s = new Star(r);
            stars.add(s);
        }

    }
    

    int border = 50;
    public void drawGrid()
    {
        stroke(255,0,255);
        textAlign(CENTER, CENTER);
        for(int i = -5; i <= 5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border); //vertical
            line(border, x, width - border, x); //horizontal
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);

        }

    }
    
    int first = -1;
    int second = -1;

    public void mousePressed()
    {

        {
            for(int i = 0; i < stars.size(); i++)
            {
                Star s = stars.get(i);

                float x = map(s.getxG(), -5, 5, border, width - border);
                float y = map(s.getyG(), -5, 5, border, height - border);

                if(dist(mouseX, mouseY, x, y) < s.getAbsMag()/2) // size/2 to make more precise
                {
                    if (first == -1) //if haven't clicked yet
                    {
                        first = i; //position in star array
                    }
                    else if(second == -1)
                    {
                        second = i;
                    }
                    else
                    {
                        first = i;
                        second = -1;
                    }

                }
            }
        } 
        
    }

    public void drawStars()
    {
        for(Star s: stars)
        {
            s.render(this);
        }
    }

    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();

        if (first != -1 && second == -1)
        {
            Star s1 = stars.get(first);
            float x = map(s1.getxG(), -5, 5, border, width - border);
            float y = map(s1.getyG(), -5, 5, border, height - border);
            stroke(255, 255, 0);
            line(x, y, mouseX, mouseY);
        }
        else if (first != -1 && second != -1)
        {
            Star s1 = stars.get(first);
            Star s2= stars.get(second);

            float x1 = map(s1.getxG(), -5, 5, border, width - border);
            float y1 = map(s1.getyG(), -5, 5, border, height - border);
            float z1 = map(s1.getzG(), -5, 5, border, height - border);

            float x2 = map(s2.getxG(), -5, 5, border, width - border);
            float y2 = map(s2.getyG(), -5, 5, border, height - border);
            float z2 = map(s2.getzG(), -5, 5, border, height - border);

            
            stroke(255, 255, 0);
            line(x1, y1, x2, y2);    
            fill(255);
            float dist = dist(x1, y1, z1, x2, y2, z2);
            text("Distance from " + s1.getDisplayName() + " to " + s2.getDisplayName() + " is " + dist + " parsecs", border, height - 25);
        }

    }

}