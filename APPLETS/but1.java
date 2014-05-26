

//PROGRAM TO SHOW THE WORKING OF BUTTON & LABEL

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code = dalla height = 600 width =800>
</applet>
*/


public class dalla extends Applet implements ActionListener,Runnable
{
    String msg = "";
    Thread t;
    Button b1 = new Button();
    Button b2 = new Button("GOOFY");
    Button b3 = new Button("MARIO");


    public void paint(Graphics g)
    {
        g.drawString(msg,100,400);
    }


    public void run()
    {
        char ch;
        String str;

        while(true)
        {
            repaint();
            str = b1.getLabel(); 

            ch = str.charAt(0);

            str = str.substring(1,str.length());
            str += ch;

            b1.setLabel(str);

            try
            {
                Thread.sleep(500);    

            }
            catch(InterruptedException e)
            {


            }

        }
    }


    public void init()
    {
        t  = new Thread(this,"hell");



        Label l1 = new Label("label & buttons");

        add(l1);

        b1.setLabel("DONALD");

        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        t.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        msg = ((Button)e.getSource()).getLabel();

        if(e.getSource()==b2)   //e.getSource() returns a reference to the object of type "Button"
            msg += " hi buddy";

        repaint();
    }

}

           
