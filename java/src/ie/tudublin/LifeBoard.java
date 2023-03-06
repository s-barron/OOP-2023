package ie.tudublin;

import processing.core.PApplet;

//life creates an instance of lifeboard
public class LifeBoard {
    boolean[][] board; //declares array without allocating memory. if you try to access it you will get a Null Pointer Exception
    boolean[][] next;

    private int size;
    PApplet p;
    float cellWidth;

    public boolean getCell(int row, int col)
    {
        //bounds checking - check if within bounds of 2D array
        if(row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }
    }

    public int countCells(int row, int col)
    {
        int count = 0;
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if( ! (i == 0) && (j == 0))
                {
                    if(getCell(i,j))
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width/(float)size;

    }

    public void applyRules()
    {
        //count < 2 = die
        //count > 3 = die
        //2 or 3 = live
        //dead and count = 3 = live
        //board and next board
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                int count = countCells(row,col);
                if(board[row][col])
                {
                    if(count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }
                    else if(count < 2 || count > 3)
                    {
                        next[row][col] = false;
                    }
                }
                else
                {
                    if(count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
            }         
        }
        boolean[][] temp = board;
        board = next;
        next = temp;

        
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