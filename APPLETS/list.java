//PROGRAM TO SHOW WORKING OF LISTS IN JAVA

/*
<applet code = dalla width = 800 height = 600>
</applet>
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class dalla extends Applet implements ActionListener
{
    List l1,l2;

    String msg="";


    public void init()
    {
        l1 = new List();
        l2 = new List(2,true);//multiple list system...2:max no items....true:mutiple list system is true

        l1.add("ANIRUDH");
        l1.add("TOSHISH");
        l1.add("GAURAV");
        l1.add("ANANYA ANURAG");

        l2.add("SE COMP-I");
        l2.add("SE COMP-II");


        l1.addActionListener(this);
        l2.addActionListener(this);

        add(l1);
        add(l2);
    }

    public void actionPerformed(ActionEvent e)
    {
        msg = "THE ITEM SELECTED ARE:  ";
        msg += l1.getSelectedItem() + "  " ;

        for(String x:l2.getSelectedItems())
        {
            msg += x + "  ";

        }

        repaint();

    }

    public void paint(Graphics g)
    {
        g.drawString(msg,100,300);
    }


}

