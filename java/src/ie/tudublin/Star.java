package ie.tudublin;

import com.jogamp.newt.Display;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star
{
    private boolean hab;
    private String DisplayName;
    private float Distance;
    private float Xg;
    private float Yg;
    private float Zg;
    private float AbsMag;

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

    public Star(boolean hab, String DisplayName,float Distance, float Xg, float Yg, float Zg, float AbsMag)
    {
        this.hab = hab;
        this.DisplayName = DisplayName;
        this.Distance = Distance;
        this.Xg = Xg;
        this.Yg = Yg;
        this.Zg = Zg;
        this.AbsMag = AbsMag;
    }

}