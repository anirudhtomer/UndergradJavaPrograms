import java.awt.*;
import java.awt.event.*;

class dalla extends Frame{

	List list1,list2;
	Checkbox c1,c2;
	CheckboxGroup g1;

	Button btnremoveall,btnremove,btnadd;
	Button b1,b2;

	TextField textfield;

	Label status;
			
	public dalla(){
		setLayout(null);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();	
			}
		});

		setSize(800,600);

		b1 = new Button("--->>");
		b2 = new Button("<<---");

		btnremoveall = new Button("REMOVE ALL ELEMENTS");
		btnremove = new Button("REMOVE SELECTED ELEMENT");
		btnadd = new Button("ADD ELEMENT");

		list1 = new List();
		list2 = new List();
		
		g1 = new CheckboxGroup();
		c1 = new Checkbox("LIST1",true,g1);
		c2 = new Checkbox("LIST2",false,g1);
	
		textfield = new TextField("NEW ELEMENT");
		status = new Label("STATUS LABEL");

		addbtnlisteners();	

		initlists();

		//add items to frame now

		add(list1);
		add(list2);
		add(b1);
		add(b2);
		add(btnremoveall);
		add(btnremove);
		add(btnadd);
		add(c1);
		add(c2);
		add(textfield);
		add(status);

		//setting locations for each	

		list1.setBounds(100,100,100,100);
		list2.setBounds(400,100,100,100);
		
		b1.setBounds(300,100,40,20);
		b2.setBounds(300,150,40,20);

		c1.setBounds(300,300,100,20);
		c2.setBounds(400,300,100,20);

		btnremoveall.setBounds(50,400,200,20);
		btnadd.setBounds(300,400,200,20);
		btnremove.setBounds(550,400,200,20);
		textfield.setBounds(300,500,200,20);
		status.setBounds(300,250,400,20);
		
	}

	private void initlists(){

		list1.add("ANIRUDH");
		list1.add("ANANYA");
		list1.add("TOSHISH");
		list1.add("SANKET");

		list2.add("PREETAM");
		list2.add("DANI");
		list2.add("LODA");		
	}

	private void addbtnlisteners(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(list1.getSelectedIndex()<0){
					status.setText("NO ELEMENT SELECTED");
				}
				else{
					list2.add(list1.getSelectedItem());	
					list1.remove(list1.getSelectedIndex());
					status.setText("");
				}
		
			}
		});
	
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(list2.getSelectedIndex()<0){
					status.setText("NO ELEMENT SELECTED");
				}
				else{
					list1.add(list2.getSelectedItem());	
					list2.remove(list2.getSelectedIndex());
					status.setText("");
				}
		
			}
		});
					
		btnremoveall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(c1.getState()){
					list1.removeAll();
				}
				else{
					list2.removeAll();
				}
				status.setText("");
			}
		});

		btnremove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(c1.getState()){

					if(list1.getSelectedIndex()<0)
						status.setText("NO ELEMENT SELECTED");
					else{
						list1.remove(list1.getSelectedIndex());
						status.setText("");
					}
				}
				else{
					if(list2.getSelectedIndex()<0)
						status.setText("NO ELEMENT SELECTED");
					else{
						list2.remove(list2.getSelectedIndex());
						status.setText("");
					}		
				}
			}
		});

		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			
				if(textfield.getText().equals("")){
					status.setText("TEXT FIELD EMPTY..must be filled");	
				}
		
				else{		
					if(c1.getState()){
						list1.add(textfield.getText());
					}
					else{
						list2.add(textfield.getText());
					}
					status.setText("");
				}

			
			}
		});

			
	}
	
	public static void main(String args[]){
		new dalla().setVisible(true);
	
	}
}
