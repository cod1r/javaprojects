import java.awt.*;
import java.util.ArrayList;

public class Objectobject {
  private int xpos;
  private int ypos;
  private Color c;
  private int size1;
    public Objectobject(int xpos1, int ypos1, Color c1,int size)
    {
       xpos = xpos1;
       ypos = ypos1;
       c=c1;
       size1 = size;
    }
    public int getXpos()
    {
        return xpos;
    }
    public int getYpos()
    {
        return ypos;
    }
    public Color getC()
    {
        return c;
    }
    public int getSize1()
    {
        return size1;
    }
}
