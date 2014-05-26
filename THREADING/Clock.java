import java.awt.*;
import java.applet.Applet;
import java.util.Date;
import java.text.SimpleDateFormat;

//<applet code = "Clock" height = "600" width = "800"> </applet>

class Hour implements Runnable{
	
	int hour;
	Thread t;
	Clock d;
	
	public Hour(String hr,Clock d){
		t = new Thread(this,"HOUR");
		t.start();
		this.d = d;
		hour = Integer.parseInt(hr);	
	}

	public void run(){
		while(true){
			synchronized(this){
				try{
					wait();

					if(hour==23)
						hour = 0;
					else
						hour++;
			
				}
				catch(Exception e){
					e.printStackTrace();
				}
			
			}
		}
	}

}

class Min implements Runnable{
	
	int min;
	Thread t;
	Clock d;
	Hour hour;

	public Min(String min,Clock d,Hour hour){
		t = new Thread(this,"MIN");
		t.start();
		this.d =d;
		this.min = Integer.parseInt(min);
		this.hour = hour;
	}

	public void run(){
		while(true){
			try{				
				synchronized(this){
				
					wait();
					if(min==59){
						min = 0;
						
						synchronized(hour){
							hour.notify();
						}					
					}
					else 
						min++;

					d.repaint();
				}
			}		
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}

class Sec implements Runnable{

	int sec;
	Thread t;
	Clock d;
	Min min;

	public Sec(String sec,Clock d,Min min){
		t = new Thread(this,"SEC");
		t.start();
		this.d =d;
		this.sec = Integer.parseInt(sec);
		this.min = min;

	}

	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
				
				if(sec==59){
					sec = 0;

					synchronized(min){
						min.notify();											
					}				
				}
				else
	    				sec++;
	
				d.repaint();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

}


public class Clock extends Applet{

	Date date;
	SimpleDateFormat sdfth,sdftm,sdfts;
	Hour hour;
	Min min;
	Sec sec;

	String str = "";

	public void init(){
		date = new Date();
		
		sdfth = new SimpleDateFormat("H");
		sdftm = new SimpleDateFormat("m");
		sdfts = new SimpleDateFormat("s");		

		hour = new Hour(sdfth.format(date),this);
		min = new Min(sdftm.format(date),this,hour);
		sec = new Sec(sdfts.format(date),this,min);
				
	}

	public void start(){

	}

	public void stop(){

	}

	public void paint(Graphics g){
		str = hour.hour + ":" + min.min + ":" + sec.sec;
		g.drawString(str,100,100);
	}
}
