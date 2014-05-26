//PROGRAM TO SHOW WORKING OF A MENU BAR

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class dilog extends Dialog
{
    dilog(Frame f,boolean factor)
    {
        super(f,"Dial",factor);

        setSize(400,400);
        setVisible(true);
        addWindowListener(new dwnd(this));
    }
}

class dwnd extends WindowAdapter
{
    dilog p;

    dwnd(dilog p)
    {
        this.p = p;
    }

    public void windowClosing(WindowEvent we)
    {
        p.dispose();
    }
}

public class dalla extends Frame
{
    wndw w;

    dalla(String str)
    {
        setTitle(str);

        addWindowListener(new wndw(this));
        makemenu();
    }

    public static void main(String args[])
    {
        dalla dj;

        dj = new dalla("HELLO DALLAY");

        dj.setSize(800,600);
        dj.setVisible(true);
    }

    public void makemenu()
    {
        //step1:  make a menubar object

        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        //step2:  make a menu
        Menu fil = new Menu("File");

        //step 3:  add some items to it
        MenuItem m1,m2,m3,m4;

        m1 = new MenuItem("New");
        m2 = new MenuItem("Open");
        m3 = new MenuItem("Close");
        m4 = new MenuItem("Exit");

        //add these items to menu
        fil.add(m1);
        fil.add(m2);
        fil.add(m3);
        fil.add(m4);

        mbar.add(fil);

        //make another menu

        Menu edito = new Menu("Edit");

        MenuItem m5,m6,m7;
        m5 = new MenuItem("Cut");
        m6 = new MenuItem("Copy");
        m7 = new MenuItem("Paste");

        Menu m8 = new Menu("Search");

        edito.add(m5);
        edito.add(m6);
        edito.add(m7);

        MenuItem m8_1,m8_2;
        m8_1 = new MenuItem("Find");
        m8_2 = new MenuItem("Replace");

        m8.add(m8_1);
        m8.add(m8_2);

        edito.add(m8);

        mbar.add(edito);

        Menu dil = new Menu("Dialog Boxes");

        MenuItem m9,m10;

        m9 = new MenuItem("Modal");
        m10 = new MenuItem("Modeless");

        dil.add(m9);
        dil.add(m10);

        mbar.add(dil);

        actions a1 = new actions(this);

        m1.addActionListener(a1);
        m2.addActionListener(a1);
        m3.addActionListener(a1);
        m4.addActionListener(a1);
        m5.addActionListener(a1);
        m6.addActionListener(a1);
        m7.addActionListener(a1);
        m8_1.addActionListener(a1);
        m8_2.addActionListener(a1);
        m9.addActionListener(a1);
        m10.addActionListener(a1);
    }
}


class wndw extends WindowAdapter
{
    dalla d;

    wndw(dalla d)
    {
        this.d = d;
    }

    public void windowClosing(WindowEvent we)
    {
        d.setVisible(false);
        System.exit(0);
    }


}

class actions implements ActionListener
{
    dalla d;
    dilog p;

    actions(dalla d)
    {
        this.d = d;
    }

    public void actionPerformed(ActionEvent ae)
    {
        String str = "";

        str = ae.getActionCommand();

        if(str.equals("Exit"))
        {
            System.exit(1);
        }

        if(str.equals("Modal"))
        {
            p = new dilog(d,true);        
        }
        if(str.equals("Modeless"))
        {
            p = new dilog(d,false);
        }
    }
}
