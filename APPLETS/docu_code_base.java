//PROGRAM TO SHOW USE OF getCodeBase() & getDocumentBase()

/*    getCodeBase() returns a "URL" class object which has the directory containig the .class file of applet
      getDocumentBase returns a "URL" class object which has the directory that contains the HTML file that has started the applet  

                 
<applet code = docu_code_base width = 500 height = 500>
</applet>

*/

import java.awt.*;
import java.applet.*;
import java.net.*;


public class docu_code_base extends Applet
{


    public void paint(Graphics g)
    {
        URL du = getDocumentBase();  //returns address of file (.java)
        URL cu = getCodeBase(); //returns address of the folder conataining that (.class) file

        String msg = "p";

        msg = du.toString();
    
        g.drawString("DOCUMENT BASE:" + msg,20,20);

        msg = cu.toString();

        g.drawString("CODE BASE:" + msg,20,40);
    }


}
