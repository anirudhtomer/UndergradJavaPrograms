//PROGRAM TO SHOW WORKING OF BORDER LAYOUT

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*

<applet code = dalla width = 800 height = 600>
</applet>

*/

public class dalla extends Applet
{
	String msg = " ";
      Button b1,b2,b3;
      TextArea t1;

	Panel panelnumber;
	Button btnnumber[];
	Button btnpoint,btnequal;

	private void addPanel(){
		panelnumber = new Panel();
		btnnumber = new Button[10];

		panelnumber.setLayout(new GridLayout(3,4));
	
		for(int i=0;i<10;i++){
			btnnumber[i] = new Button("" + i);
			panelnumber.add(btnnumber[i]);
		}
		
		btnpoint = new Button(".");
		btnequal = new Button("=");

		panelnumber.add(btnpoint);
		panelnumber.add(btnequal);	

		add(panelnumber);

		panelnumber.setBounds(100,100,400,400);	
		
	}

      public void init()
      {
		setLayout(null);		
		addPanel();
	}
}
