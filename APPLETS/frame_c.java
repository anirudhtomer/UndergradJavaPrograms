//PROGRAM TO SHOW WORKING OF A FRAME

/*

<applet code = dalla height = 600 width = 700 >
</applet>

*/

import java.awt.*;
import java.applet.*;

/* the following code has a Frame class in dalla but do u know the following operations are for the applet window panel not for frame......& u can't do much with these functions
for the frame...like u can't close the window frame directly by clicking on the "x"at the top of the taskbar.
*/
public class dalla extends Applet
{
    Frame f;
    String str;
    boolean x;
    
    public void init()
    {
        str = "HI THIS IS AN APPLET";
        x = true;
        f = new Frame("dalla frame");
    }

    public void start()
    {
        f.setVisible(x);
        f.setSize(100,100);

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
