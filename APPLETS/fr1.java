//PROGRAM TO SHOW WORKING OF FRAME

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class dalla extends Frame implements  Runnable
{
    String keymsg,mousemsg="mouse";
    int x=19,y=10,msx=50,msy=50;
    boolean xfact = true;
    Thread t;

    dalla()
    {
        t = new Thread(this,"hi");
        addWindowListener(new wnadap(this));
        addKeyListener(new kyadap(this));
        addMouseMotionListener(new msadap(this));
//        requestFocus();//it's the function of window

        t.start();
    }

    public void run()
    {

        char ch;

        while(xfact)
        {

            repaint();

            ch = mousemsg.charAt(0);

            mousemsg = mousemsg.substring(1,mousemsg.length());
            mousemsg+=ch;

            x+=5;
            y+=5;
            try
            {
                Thread.sleep(100);

            }
            catch(InterruptedException e)
            {
            }

            if(x>400)
                x = 10;
            if(y>400)
                y = 10;
        }
    }


    public static  void main(String  args[])
    {
        dalla dj = new dalla();                    

        dj.keymsg = "ni";
        dj.setVisible(true);
        dj.setSize(1280,800);
        dj.setTitle("joker");
        
    }

    public void paint(Graphics g)
    {
        g.drawString(keymsg,x,y);
        g.drawString(mousemsg,msx,msy);

    }

}

class wnadap extends WindowAdapter
{
    dalla d;

    wnadap(dalla  d)
    {
        this.d = d;
    }

    public void windowClosing(WindowEvent we)
    {
        d.xfact = false;
        d.setVisible(false);
        System.exit(0);
    }
}

class kyadap implements KeyListener
{
    dalla d;

    kyadap(dalla  d)
    {
        this.d = d;
    }

    public void keyReleased(KeyEvent ke)
    {     
        d.keymsg = "KEY RELEASED" + " " + ke.getKeyChar() + ke.getKeyCode();
        d.repaint();        
    }

    public void keyPressed(KeyEvent ke)
    {
        d.keymsg = "KEY PRESSED" + " " + ke.getKeyChar()+ ke.getKeyCode();
        d.repaint();        
    }

    public  void keyTyped(KeyEvent ke)
    {
        d.keymsg  ="KEY IS TYPED";
        d.repaint();

    }
    
}

class msadap implements MouseMotionListener
{
    dalla d;

    msadap(dalla d)
    {
        this.d = d;
    }

    public void mouseMoved(MouseEvent me)
    {
        d.msx = me.getX();
        d.msy = me.getY();
        d.mousemsg = "mouse moved" + " " + me.getX() + "," + me.getY();
        d.repaint();            
    }

    public void mouseDragged(MouseEvent me)
    {
        d.msx = me.getX();
        d.msy = me.getY();
        d.mousemsg = "mouse dragged" + " " + me.getX() + "," + me.getY();
        d.repaint();            
    }



}
