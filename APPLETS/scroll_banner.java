//A SIMPLE APPLET BANNER

/*

<applet code = dalla width = 500 height = 400>
</applet>

*/

import java.awt.*;
import java.applet.*;

public class dalla extends Applet implements Runnable
{
    int banx = 100,bany = 100;
    char ch;
    Thread t;
    private String str;
    boolean stopper = true;

    public void run()
    {
        while(true)
        {

            repaint(500); 

            ch = str.charAt(0);
            str = str.substring(1,str.length());
                
            str += ch;

            banx++;
            bany++;

            try
            {
                t.sleep(100);
            }
            catch(InterruptedException e)
            {
               
            }

            if(stopper)
                break;

        }
    }

    
    public void init()
    {
        str = "HI IAM ANIRUDH TOMER";
        setBackground(Color.yellow);
        setForeground(Color.blue);
    }

    public void start()
    {
        t = new Thread(this,"NOT THE MAIN THREAD");    
        stopper = !stopper;
        t.start();
    }

    public void paint(Graphics g)
    {
        g.drawString(str,banx,bany);

        if(stopper)
            showStatus("THE BANNER IS NOT SCROLLING");  //showstatus shows the thing in status window
        else
            showStatus("THE BANNER IS SCROLLING");  //showstatus shows the thing in status window
    }

    public void stop()
    {
        t = null;
    }

}
    
