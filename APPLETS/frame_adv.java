//PROGRAM TO SHOW WORKING OF A FRAME

/*

<applet code = dalla height = 600 width = 700>
</applet>

*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

class smplframe extends Frame implements MouseListener,MouseMotionListener,Runnable
{
    String pwr = "hello";
    Thread t;
    String ban = "HI IAM ANIRUDH";
    int banx,bany;

    public void init()
    {
        t = new Thread(this,"NTHRD");
        t.start();
    }

    public void start()
    {
        banx = 40;
        bany = 400;
    }

    smplframe(String msg)
    {
        super(msg);
        addWindowListener(new wndw(this));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e)
    {
        pwr = "MOUSE MOVED AT ";
        pwr += e.getX() + "," + e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e)
    {
        pwr = "MOUSE DRAGGED AT ";
        pwr += e.getX() + "," + e.getY();
        repaint();
    }

    public void mouseExited(MouseEvent me)
    {
        pwr = "mouse exited";
        repaint();
    }

    public void mouseEntered(MouseEvent me)
    {
        pwr = "mouse entered";
        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {
        pwr = "MOUSE RELEASED AT ";
        pwr += e.getX() + "," + e.getY();
        repaint();
    }

    public void mousePressed(MouseEvent e)
    {
        pwr = "MOUSE PRESSED AT ";
        pwr += e.getX() + "," + e.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent e)
    {
        pwr = "MOUSE CLICKED AT ";
        pwr += e.getX() + "," + e.getY();
        repaint();
    }

    public void run()
    {
        try
        {
            while(true)
            {
                Thread.sleep(1000);
                banx++;
                bany++;
                repaint();
            }

        }

        catch(InterruptedException e)
        {

        }
    }

    public void paint(Graphics g)
    {
        g.drawString(pwr,100,100);
        g.drawString(ban,banx,bany);
    }
}

class wndw extends WindowAdapter

{

/*
    instead of making this class extend adapter i could have implemented windowadapter
    in the smmplframe class but then i would had to override all functions of it.
*/

    smplframe smpl;

    wndw(smplframe curt)
    {
        smpl = curt;
    }

    public void windowClosing(WindowEvent e)
    {
        smpl.setVisible(false);
    }
}

public class dalla extends Applet
{
    Frame f;
    String str;
    boolean x;
    
    public void init()
    {
        str = "HI THIS IS AN APPLET";
        x = true;
        f = new smplframe("dalla frame");
    }

    public void start()
    {
        f.setVisible(x);
        f.setSize(500,300);

        if(x)
            x = false;
        else
            x = true;

    }

    public void stop()
    {
        f.setVisible(false);
    }

    public void paint(Graphics g)
    {
        g.drawString(str,200,200);
    }

}
