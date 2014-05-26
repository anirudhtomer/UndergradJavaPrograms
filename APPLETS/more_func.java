//MORE APPLET FUNCTIONS

/*   FOLLOWING FUNCTIONS ARE REQUIRED WHILE WRITING APPLET CODES

1.  the init() function is called when the first time an applet is made available on
    a web browser

2.  the start() function is called the user leaves the webpage & comes back

3.  the stop() function is used to stop the threads in execution while the applet is not in view
    they can be later on started by the start() method

4.  the destroy() is called when applet is needed to be completely removed from RAM




<applet code = more_func width = 500 height = 400>
</applet>

*/

import java.awt.*;
import java.applet.*;

public class more_func extends Applet
{
    static int i = 0;
    String msg = "anirudh tomer";

    public void init()
    {
        setBackground(Color.yellow);
    }

    public void start()
    {

    }

    public void paint(Graphics g)
    {
        g.drawString(msg,40,40);

        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException e)
        {
            System.out.println("INTERRUPTED DATA");
        }
         

        setForeground(Color.green);
        setBackground(Color.red);

        msg = "programmers rock";

        /*

         i have passed 5000 ms as delay time....it doesn't mean that
         "update()" will be called after 5sec.....it means within 5sec update may be called
         & if 5 sec get over & update isn't called then it's not called after that.

        */
        if(i==0)
            repaint(5000);
        i++;
    }             
}
    
