//PROGRAM TO WRITE A SIMPLE APPLET

/*
    HOW TO COMPILE

    javac basc_app.java
    appletviewer basc_app.java

    THIS RUNS THE APPLET VIEWER APPLICATION



applet is a program that is accessed on a net server,transferred over net,
automatically installed & run as a part of the web document
it does not use most of the resources of the recipient & produces a fantastic GUI

*/



import java.awt.*;    //import abstract window toolkit(AWT) class
import java.applet.*; //import applet class


/*   THE FOLLOWING 2 LINES OF CODE IS TO BE NECESSARILY WRITTEN IN THIS PROGRAM
    width & height of display area are to be provided





<applet code = "basc_app" width = 500 height = 500>
</applet>





*/

/*  most of the applet programs do not have a main function

    since the class basc_app has to be accessed from the appletviewer.exe &
    other packages thus it has to be declared public & the overridden
    "paint" method is also to declared as public.

    The "Applet class" is a member of the "package applet"
    & the "paint method" is from The AWT

    to draw the applet "paint" method is called...like when applet is maximized
    or is overwritten by another window & you wanna take it in front then paint is called

    it has been passed object of "Graphics class" as a parameter which tells about the graphics environment in which
    applet is running & a has a method to write a string
*/



public class basc_app extends Applet
{
    public void paint(Graphics g)
    {
        g.drawString("HI IAM ANIRUDH TOMER",230,230);
    }    

}
