import java.awt.*;
import java.awt.event.*;
import java.applet.*;

//<applet code = "dalla" width = "600" height = "600"></applet>

public class dalla extends Applet{

	Scrollbar red,green,blue;
	int r=10,g=10,b=10;

	TextField txtfield;

	int txtwidth = 5;

	int mx,my;
	
	Checkbox eraser,filler;
	CheckboxGroup g1;
	
	Boolean flagclearall = false;
		
	Button clearall;
	AdjustmentListener adjlistener;

	//my functions

	private void addCheckbox(){

		g1 = new CheckboxGroup();

		eraser = new Checkbox("ERASER",true,g1);
		filler = new Checkbox("FILLER",true,g1);
	
		add(eraser);
		add(filler);

		eraser.setBounds(70,20,70,20);
		filler.setBounds(160,20,70,20);			

	}

	private void addScroll(){

		red = new Scrollbar(Scrollbar.HORIZONTAL);
		red.setMaximum(255);
		red.setMinimum(0);
		red.setUnitIncrement(1);
		red.setValue(0);
		r = red.getValue();

		green = new Scrollbar(Scrollbar.HORIZONTAL);
		green.setMaximum(255);
		green.setMinimum(0);
		green.setUnitIncrement(1);
		green.setValue(0);
		g = green.getValue();

		blue = new Scrollbar(Scrollbar.HORIZONTAL);
		blue.setMaximum(255);
		blue.setMinimum(0);
		blue.setUnitIncrement(1);
		blue.setValue(0);
		b = blue.getValue();

		Label l1 = new Label("RED COMPONENT");		
		Label l2 = new Label("GREEN COMPONENT");		
		Label l3 = new Label("BLUE COMPONENT");		
		
		l1.setBounds(50,100,120,20);
		l2.setBounds(50,130,120,20);
		l3.setBounds(50,160,120,20);

		add(l1);
		add(l2);
		add(l3);

		add(red);			
		add(green);			
		add(blue);		

		red.setBounds(200,100,150,20);	
		green.setBounds(200,130,150,20);
		blue.setBounds(200,160,150,20);
	
		adjlistener = new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent ae){
				r = red.getValue();
				g = green.getValue();
				b = blue.getValue();
			}		
		};

		red.addAdjustmentListener(adjlistener);
		green.addAdjustmentListener(adjlistener);
		blue.addAdjustmentListener(adjlistener);

	}	

	private void addTextField(){

		Label l1 = new Label("ENTER THE WIDTH");
		add(l1);
		
		l1.setBounds(50,50,200,20);
		
		txtfield = new TextField("5");
		add(txtfield);
	
		txtfield.setBounds(270,50,100,20);


	}


	//overridden function
	public void init(){
		
		setLayout(null);
		addScroll();

		addTextField();
		addCheckbox();

		clearall = new Button("CLEAR ALL");
		add(clearall);
		clearall.setBounds(380,50,130,20);

		clearall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				flagclearall = true;
				repaint();
			}

		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent me){

				mx = me.getX();
				my = me.getY();

				txtwidth = Integer.parseInt(txtfield.getText().trim());
				repaint();
			}
		});		
	}

	public void start(){


	}
	
	public void stop(){


	}


	public void paint(Graphics g){
		
		
		if(flagclearall){
			g.setColor(Color.WHITE);
			g.fillRect(100,200,400,350);		

		}
		
		g.setColor(Color.BLACK);
		g.drawRect(100,200,400,350);
		
		if(!flagclearall){

			if(mx<= (100+txtwidth) || mx>=(500 - txtwidth))
				return;

			if(my<= (200 +txtwidth) || my>= (550 - txtwidth))
				return;


			if(eraser.getState())
				g.setColor(Color.WHITE);
			else
				g.setColor(new Color(r,this.g,b));  
			//this.g coz there is one more local varible "g" of class Graphics

			g.fillOval(mx,my,txtwidth,txtwidth);
		}

		flagclearall = false;

	}

	public void update(Graphics g){
		paint(g);
	}


}
