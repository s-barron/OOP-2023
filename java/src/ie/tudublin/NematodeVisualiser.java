package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;


public class NematodeVisualiser extends PApplet{

    ArrayList<Nematode> nems = new ArrayList<Nematode>();

    public void loadNematodes()
    {
        Table table;
        
        table = loadTable("nematodes.csv", "header");

        for(TableRow r: table.rows())
        {
            Nematode n = new Nematode(r);
            nems.add(n);
            
        }

    }

    public void settings()
    {
        size(800,800);
        loadNematodes();
    }

    public void setup()
    {
        colorMode(RGB);
    }


    public void drawNematodes()
    {
        for(Nematode n: nems)
        {
            n.render(this);
        }
    }

    public void draw()
    {
        background(0);
        //drawNematodes();
        nems.get(0).render(this);
    }


    
}
