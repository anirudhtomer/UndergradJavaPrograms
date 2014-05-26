//PROGRAM TO SHOW THE WORKING OF DROP-DOWN LIST

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import 


/*
<applet code = dalla height = 600 width = 800>
</applet>
*/

public class dalla extends Applet implements ItemListener
{
    Choice c1,c2;
    String msg ="THE ITEM SELECTED IS:-";

    public void init()
    {
        c1 = new Choice();
        c2 = new Choice();

        c1.add("SE COMP-I");
        c1.add("SE COMP-II");

        c2.add("ANIRUDH TOMER");
        c2.add("PREETAM SHINGHAVI");
        c2.add("ANANYA ANURAG");
        c2.add("TOSHISH JAWALE");

        add(c1);
        add(c2);


        c1.addItemListener(this);
        c2.addItemListener(this);


    }

    public void itemStateChanged(ItemEvent ie)
    {
        msg ="THE ITEM SELECTED IS:-";

        msg += c1.getSelectedItem() + " " +c2.getSelectedItem();
        repaint();
    }

    public void paint(Graphics g)
    {
        g.drawString(msg,100,300);

    }

}


