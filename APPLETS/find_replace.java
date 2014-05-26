import java.awt.*;
import java.awt.event.*;

class dalla extends Frame{

	TextArea textarea;

	Button search;
	TextField textsearch,textreplace;

	public dalla(){

		setLayout(null);

		textarea = new TextArea();
		search = new Button("Search n Replace");
		textsearch = new TextField();
		textreplace = new TextField();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
			}	
		});

		setSize(800,700);

		add(textarea);
		add(textsearch);
		add(textreplace);
		add(search);

		Label l1 = new Label("SEARCH");
		Label l2 = new Label("REPLACE");

		add(l1);		
		add(l2);

		l1.setBounds(30,500,60,20);
		l2.setBounds(30,550,60,20);

		textarea.setBounds(100,50,600,350);	
		textsearch.setBounds(100,500,100,20);
		textreplace.setBounds(100,550,100,20);
		search.setBounds(300,500,200,25);

		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				textarea.setText(textarea.getText().replaceAll(textsearch.getText(),textreplace.getText()));
			}
		});		

	}

	public static void main(String args[]){
		new dalla().setVisible(true);

	}


}
