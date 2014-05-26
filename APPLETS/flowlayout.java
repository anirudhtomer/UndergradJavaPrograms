//PROGRAM TO SHOW WORKING OF FLOW LAYOUT

/*

<applet code = dalla width = 800 height = 600>
</applet>

*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class dalla extends Applet implements ActionListener
{
    String msg = "HI IAM ANIRUDH";
    Button b1,b2,b3;

    public void init()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT,20,20));

        b1 = new Button("HELLO");
        b2 = new Button("BYE");
        b3 = new Button("IAM ANIRUDH");

        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {
        msg = ((Button)ae.getSource()).getLabel();
        repaint();
    }

    public void paint(Graphics g)
    {
        g.drawString(msg,100,300);
    }
}


