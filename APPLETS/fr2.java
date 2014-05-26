import java.awt.*;
import java.awt.event.*;

class dalla extends Frame

{
    Dimension d = new Dimension();
    String keymsg="buffalo";
    dalla()
    {
        addWindowListener(new winadp(this));
    }
    public static void main(String args[])
    {

        dalla f = new dalla();
        f.setVisible(true);
        f.setSize(400,500);
        f.setTitle("Toshish");
        
       
        
        f.repaint();

    }
    public void paint(Graphics g)
    {
        d = getSize(); //Its a function of window class whos sub class is frame.
        keymsg = d.width + " " + d.height;

        Color c = new Color(110,10,23);

        

   //     g.setColor(Color.yellow);
        setBackground(c.red);
        setForeground(Color.blue);

//        g.drawLine(0,0,100,100);
  //      g.drawRect(0,0,100,100);
        g.fillRect(50,50,100,100);
      //  g.drawRoundRect(50,50,100,100,80,20);
      //  g.drawArc(200,200,50,100,90,180);
        g.drawString(keymsg,300,300);
        g.setXORMode(Color.yellow);
        g.drawLine(10,20,110,120);


    }
}

class winadp extends WindowAdapter
{
    dalla d;



    winadp(dalla d)
    {
        this.d=d;
    }
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}
