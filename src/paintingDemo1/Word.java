package paintingDemo1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Word extends drawings// ‰»ÎŒƒ◊÷¿‡
{
 void draw(Graphics2D g2d)
 {
         g2d.setPaint(new Color(R,G,B));
         g2d.setFont(new Font(s2,x2+y2,((int)stroke)*18));
         if (s1!= null )
         g2d.drawString(s1,x1,y1);
        }
}