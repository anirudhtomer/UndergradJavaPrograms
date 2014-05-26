import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class dalla extends JFrame{
	
	JLabel labelnorth,labelsouth,labelcenter,labeleast,labelwest;

	ImageIcon imageicon;
	Image image;

	FileDialog filedialog;

	public dalla(){

		setLayout(new BorderLayout());		

		setSize(800,600);
		
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent we){
				dispose();
			}
		});
		
		filedialog = new FileDialog(this);
		filedialog.setMode(FileDialog.LOAD);
	
		JOptionPane.showMessageDialog(this.getContentPane(),"PLEASE PRESS OK\n\nand \n\nBROWSE AN IMAGE\n\nPRESS ENTER TO GET IMAGE IN CENTER\nUSE ARROW KEYS FOR OTHER");
	
		String filepath;	

		while(true){
			filepath = "";
			filedialog.show();	
		
			if(!(filedialog.getDirectory()==null)){
				filepath = filedialog.getDirectory().replace((char)(92),'/') + filedialog.getFile();
				break;
			}
			
		}
	
		imageicon = new ImageIcon(filepath);
		image = imageicon.getImage();		
	
		labelnorth = new JLabel();
		labelsouth = new JLabel();
		labeleast = new JLabel();
		labelwest = new JLabel();
		labelcenter = new JLabel();

		labelnorth.setPreferredSize(new Dimension(100,100));
		labelsouth.setPreferredSize(new Dimension(100,100));
		labelwest.setPreferredSize(new Dimension(100,100));
		labeleast.setPreferredSize(new Dimension(100,100));
		labelcenter.setPreferredSize(new Dimension(100,100));

		imageicon = new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_SMOOTH));
		
		labelcenter.setIcon(imageicon);

		add(labelnorth,BorderLayout.NORTH);
		add(labelsouth,BorderLayout.SOUTH);
		add(labeleast,BorderLayout.EAST);
		add(labelwest,BorderLayout.WEST);
		add(labelcenter,BorderLayout.CENTER);				
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){

				int i = ke.getKeyCode();

				if(i==37 || i==38 || i==39 || i==40 || i==10){
					
					labelnorth.setIcon(null);
					labelsouth.setIcon(null);
					labeleast.setIcon(null);												
					labelwest.setIcon(null);
					labelcenter.setIcon(null);

					switch(ke.getKeyCode()){

						case 37: labelwest.setIcon(imageicon); 
							 break;
						case 38: labelnorth.setIcon(imageicon);
							 break;
						case 39: labeleast.setIcon(imageicon);
							 break;
						case 40: labelsouth.setIcon(imageicon);
							 break;	
						case 10: labelcenter.setIcon(imageicon);

					}
				}
				
			}
		});		
	
	}
	
	public static void main(String args[]){
		new dalla().setVisible(true);
	}

}
