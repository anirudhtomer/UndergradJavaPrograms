//PROGRAM TO SHOW WORKING OF BORDER LAYOUT

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*

<applet code = dalla width = 800 height = 600>
</applet>

*/

public class dalla extends Applet implements ActionListener
{
    String msg = " ";
    Button b1,b2,b3;
    TextArea t1;

    public void init()
    {
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());

        String str = "HI THIS IS A TEXT AREA WHERE U CAN WRITE ANYTHING" +
                     "anything means u can write anything regarding anything" +
                     ".....like what u have done today or any girl u like";


        b1 = new Button("HELLO");
        b2 = new Button("HI");
        b3 = new Button("BYE BYE");
        t1 = new TextArea(str);

        add(b1,BorderLayout.EAST);
        add(b2,BorderLayout.WEST);
        add(b3,BorderLayout.NORTH);
        add(new Label("THIS IS A BORDER LAYOUT THEME"),BorderLayout.SOUTH);
        add(t1,BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {           
        msg = " " + ((Button)ae.getSource()).getLabel();
        repaint();
    }

    public void paint(Graphics g)
    {
        g.drawString(msg,100,300);
    }

    /* THE FOLLOWING CODE ISN'T A NECESSARY PART OF THIS PROGRAM
       however sometimes u wanna set the window size of the applet,
       so u can use this */


    public Insets getInsets()
    {
        return new Insets(20,20,20,200);
    }
}
