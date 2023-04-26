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
    
    Star first = null;
    Star second = null;

    public void mousePressed()
    {
        int clicked = 0;

        {
            for(Star s:stars)
            {
                float x = map(s.getxG(), -5, 5, border, width - border);
                float y = map(s.getyG(), -5, 5, border, height - border);
                if((mouseX < x+5 && mouseX < x-5) && (mouseY < y+5 && mouseY < y-5))
                {
                    first = s;
                    clicked = 1;
                    mouseDragged(x,y);
                }
            }
        }

        
        
    }

    public void mouseDragged(float x, float y)
    {
        stroke(255,255,0);
        line(x,y,mouseX,mouseY);
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

    }

    



}