package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    PApplet p;
    
    float size;
    private int c;
    private float rot;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        pos =  new PVector();
        this.size = size;
        this.c = c;
        this.p = p;
    }
    public PVector getPos(){
        return pos;
    }

    public void setPos(PVector pos){
        this.pos = pos;
    }
    
    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    int x = 0, y = 0;
    private float halfSize;
    public void render()
    {
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.stroke(c,255,255); 
        p.line(-halfSize, halfSize, 0, -halfSize);
        p.line(0, -halfSize, halfSize,halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
    }

    public void move()
    {
        if (p.keyPressed)
        {
            if(p.keyCode == PApplet.LEFT)
            {
                rot -= 0.1f;
            }
            if(p.keyCode == PApplet.RIGHT)
            {
                rot += 0.1f;
            }
            if(p.keyCode == PApplet.UP)
            {
                pos.y--;
            }
            if(p.keyCode == PApplet.DOWN)
            {
                pos.y++;
            }
        }
    }
}
