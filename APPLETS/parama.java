/*

<applet
code = parama
height = 600
width = 600
            >

<param name = fontname  value=hello >    //param means parameter
<param name = fontsize value = 14>


</applet>

*/

import java.awt.*;
import java.applet.*;


public class parama extends Applet
{
    String NAME = "anitype mit";
    String getname;
    int SIZE;


    public void init()
    {
        setBackground(Color.orange);
        setForeground(Color.black);
    }

    public void start()
    {

        NAME += getParameter("fontname");


        getname = getParameter("fontsize");

        try
        {
            /* the following code is to covert string into equivalent integer value
                u can covert

                Float.valueOf(getname).floatValue();
             or Boolean.valueOf(getname).booleanValue();

             to get equivalent values

             */


            if(getname!=null)
                SIZE = Integer.valueOf(getname).intValue();
            else
                SIZE = 0;

        }

        catch(NumberFormatException e)
        {

        }
    }                                   

    public void paint(Graphics g)
    {
        showStatus("I LIVE AT THIS APPLET");

        g.drawString("FONT NAME:  " +NAME, 20,20);
        g.drawString("FONT SIZE:  " +SIZE, 20,40);

    }
}
