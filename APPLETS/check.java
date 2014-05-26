//PROGRAM TO SHOW WORKING OF A CHECKBOX

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code = dalla height = 600 width = 800>
</applet>
*/

public class dalla extends Applet implements ItemListener
{
    Checkbox c1[];
    int mx,my;
                 

    public void init()
    {
        c1 = new Checkbox[3]; //the memory is allocated for references only

        c1[0] = new Checkbox();// memory for individual checkbox inside array is to be allocated compulsarily
        c1[1] = new Checkbox("TOSHISH");
        c1[2] = new Checkbox("GAURAV",false);


        c1[0].setLabel("ANIRUDH");

        c1[0].setState(false);
        c1[1].setState(true);


        add(c1[0]);
        add(c1[1]);
        add(c1[2]);


        for(Checkbox x:c1)
            x.addItemListener(this);


    }

    public void itemStateChanged(ItemEvent ie)
    {
        repaint();
    }

    public void paint(Graphics g)
    {
        mx = 100;
        my = 100;

        for(Checkbox x:c1)
        {
            g.drawString(x.getLabel()+" is set" +x.getState(),mx,my);
            my += 20;
        }

    }
}
