//PROGRAM TO SHOW THE WORKING OF WINDOW CLOSING EVENT 

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class dalla extends Frame
{
    String keymsg;

    dalla()
    {
        addWindowListener(new windowadap(this));
    }

    public void paint(Graphics g)
    {
        g.drawString(keymsg,100,100);
    }

    public static void main(String args[])
    {
        dalla dj = new dalla();

        dj.keymsg = "hi mit";

        dj.setSize(new Dimension(400,400));
        dj.setVisible(true);
        dj.setTitle("DALLED APPLICATION");
    }
}


class windowadap extends WindowAdapter
{
    dalla d;
      

    windowadap(dalla d)
    {
        this.d = d;
        d.keymsg = "hello what's up";
        d.repaint();
    } 

    public void windowClosing(WindowEvent we)
    {
        d.setVisible(false);
        System.exit(0);
    }
}               

