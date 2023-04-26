package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {
    ArrayList<Star> stars = new ArrayList<Star>();

    public void settings()
    {
        size(800,800);
    }

    public void setup()
    {
        loadData();
    }
    public void loadData(){

        Table table;

        table = loadTable("HabHYG15ly.csv","header");

        for(TableRow r: table.rows()) {
            Star s = new Star(r);
            stars.add(s);
        }

    }
}