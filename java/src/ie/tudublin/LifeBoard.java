package ie.tudublin;

import processing.core.PApplet;

//life creates an instance of lifeboard
public class LifeBoard {
    boolean[][] board; //declares array without allocating memory. if you try to access it you will get a Null Pointer Exception

    private int size;
    PApplet p;
    float cellWidth;

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean[size][size];
        this.p = p;
        cellWidth = p.width/(float)size;

    }

    public void randomise()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float dice = p.random(0,1);  // random function is a method on PApplet class
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public void render()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float x = col*cellWidth;
                float y = row*cellWidth;

                if(board[row][col])
                {
                    p.fill(0,255,0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x,y,cellWidth,cellWidth);
            }
        }
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    
}