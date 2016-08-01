package paintingDemo1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class fillOval extends drawings// µ–ƒÕ÷‘≤
{
 void draw(Graphics2D g2d)
 {g2d.setPaint(new Color(R,G,B));
  g2d.setStroke(new BasicStroke(stroke));
  g2d.fillOval(Math.min(x1,x2),Math.min(y1,y2),
               Math.abs(x1-x2),Math.abs(y1-y2));
        }
}
