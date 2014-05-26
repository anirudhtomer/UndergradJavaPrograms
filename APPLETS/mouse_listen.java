// PROGRAM TO SHOWN WORKING OF AN EVENT

/*

<applet code ="mouse_listen" height = 600 width = 700>
</applet>

*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class mouse_listen extends Applet implements  MouseListener , MouseMotionListener
{
    String str;

    int msx,msy;

    public void init()
    {
        setBackground(Color.green);
        setForeground(Color.orange);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void start()
    {
        str = "SYSTEM START";       
    }

    public void mouseClicked(MouseEvent me)
    {
        msx = me.getX();
        msy = me.getY();
        str = "mouse clicked";
        repaint();
    }

    public void mouseEntered(MouseEvent me)
    {
        showStatus("mouse entered");
    }

    public void mouseExited(MouseEvent me)
    {
        showStatus("mouse exited");
    }


    public void paint(Graphics g)
    {
        g.drawString(str,msx,msy);
    }

    public void mousePressed(MouseEvent me)
    {
        msx = me.getX();
        msy = me.getY();
        str = "MOUSE PRESSED";
        repaint();
    }

    public void mouseReleased(MouseEvent me)
    {
        msx = me.getX();
        msy = me.getY();
        str = "MOUSE RELEASED";
        repaint();
    }

    public void mouseDragged(MouseEvent me)
    {
        showStatus("MOUSE DRAGGED AT:-  " + me.getX() + "," + me.getY() );
    }
    public void mouseMoved(MouseEvent me)
    {
        showStatus("MOUSE MOVED AT:-  " + me.getX() + "," + me.getY() );
    }
}
