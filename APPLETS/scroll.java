//PROGRAM TO SHOW WORKING OF A SCROLL BAR


/*

<applet code = dalla width = 800 height = 500>
</applet>

*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class dalla extends Applet implements AdjustmentListener//,MouseMotionListener
{
    Scrollbar s1,s2;
    String vertmsg,horizmsg;

    public void init()
    {
        s1 = new Scrollbar(Scrollbar.VERTICAL,20,1,10,100); //vertical orientation,initial value,thumbsize(size of scroll),min value,max value
        s2 = new Scrollbar(Scrollbar.HORIZONTAL,20,1,10,100); //vertical orientation,initial value,thumbsize(size of scroll),min value,max value

        //u can't go less than min value but can keep the starting value anything(even less than min value...in that case min value is starting value)
        
        add(s1);
        add(s2);

        s1.addAdjustmentListener(this);
        s2.addAdjustmentListener(this);

    }

    public void adjustmentValueChanged(AdjustmentEvent me)
    {
        repaint();
    }

    public void paint(Graphics g)
    {
        vertmsg = "VERTICAL SCROLL: " + s1.getValue();
        horizmsg = "HORIZONTAL SCROLL: " + s2.getValue();

        g.drawString(vertmsg + "      " + horizmsg,100,300);
    }
}
