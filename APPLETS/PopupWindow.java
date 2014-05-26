import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopupWindow extends JFrame implements ActionListener 
{
	JPanel p;
	JLabel l;
	Timer move;
	Timer wait;
	Timer moveback;
	int verticalPos;
	Dimension d;
	Toolkit toolkit;
	

	public PopupWindow() 
	{
		l = new JLabel("Hi I am Of Toshish's!",JLabel.CENTER);
		p = new JPanel();
		p.add(l);
		d = new Dimension();
		toolkit = Toolkit.getDefaultToolkit();		
		d = toolkit.getScreenSize();
		
		verticalPos = d.height;
		setUndecorated(true);
		setSize(200,150);
		setLocation(824,618);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		setVisible(true);
		move = new Timer(30,this);
		wait = new Timer(5000,this);
		wait.setRepeats(false);
		moveback = new Timer(30,this);
		move.start();
		System.out.println("Constructor!!");
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(move.isRunning())
		{
			if(verticalPos>d.height-150)
			{
				verticalPos-=5;
				setLocation(d.width-200,verticalPos);
			} 
			else
			{
				move.stop();
				wait.start();
			}
		}
		else
		{
			if((!move.isRunning()) && (!moveback.isRunning()))
			{
				wait.stop();
				moveback.start();
			}
			else if(moveback.isRunning())
			{
				if(verticalPos<d.height)
				{
					verticalPos+=5;
					setLocation(d.width-200,verticalPos);
				}
				else
				{
					moveback.stop();
					System.exit(0);
				}
			}
		}
	}
	public static void main(String args[])
	{
		new PopupWindow();
	}
}

