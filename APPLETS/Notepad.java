import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Notepad extends Frame{
		
	MenuBar menubar;
	Menu menufile,menuoption,menufont;

	MenuItem mnunew,mnuopen,mnusave,mnufont[],mnuexit,mnucut,mnucopy,mnupaste;

	FileDialog filedialog;
	TextArea textarea;
	ActionListener actionfont;
	
	String buff = "";
	int selstart = 0,selend = 0;

	String filepath;
	Toolkit tkit;

	public Notepad(){
		setLayout(null);
		setSize(800,700);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}		
		});
	
		tkit = Toolkit.getDefaultToolkit();

		addMenuBar();
		textarea = new TextArea();

		add(textarea);
		textarea.setBounds(10,50,getWidth()-10,getHeight()-10);

		filedialog = new FileDialog(this);		
	}

	private void addMenuBar(){
		
		menubar = new MenuBar();
		setMenuBar(menubar);

		menubar.add((menufile = new Menu("File")));
		menubar.add((menuoption = new Menu("Option")));
		menufont = new Menu("Font");
			
		mnunew = new MenuItem("New");
		mnuopen = new MenuItem("Open");
		mnusave = new MenuItem("Save");
		mnuexit = new MenuItem("Exit");
		mnucut = new MenuItem("Cut");
		mnucopy = new MenuItem("Copy");
		mnupaste = new MenuItem("Paste");

		menufile.add(mnunew);
		menufile.add(mnuopen);
		menufile.add(mnusave);
		menuoption.add(menufont);
		menuoption.addSeparator();
		menuoption.add(mnucut);
		menuoption.add(mnucopy);
		menuoption.add(mnupaste);
		menuoption.addSeparator();		
		menuoption.add(mnuexit);

		String fontarr[] = tkit.getFontList();		
		mnufont = new MenuItem[fontarr.length];
		
		actionfont = new ActionListener(){
			public void actionPerformed(ActionEvent ae){

				Font f = textarea.getFont();
				textarea.setFont(new Font(ae.getActionCommand(),f.getStyle(),f.getSize()));
			}
		};

		int i;

		for(i=0;i<fontarr.length;i++){
			mnufont[i] = new MenuItem(fontarr[i]);
			menufont.add(mnufont[i]);
			mnufont[i].addActionListener(actionfont);
		}

		mnucut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				buff = textarea.getSelectedText();
				selstart = textarea.getSelectionStart();
				selend = textarea.getSelectionEnd();

				String strtemp = textarea.getText();
				textarea.setText(strtemp.substring(0,selstart) + strtemp.substring(selend,strtemp.length()));			
			}
		});

		mnucopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				buff = textarea.getSelectedText();
				selstart = textarea.getSelectionStart();
				selend = textarea.getSelectionEnd();

			}
		});

		mnupaste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String strtemp = textarea.getText();
				selstart = textarea.getSelectionStart();
				selend = textarea.getSelectionEnd();

				String temp2 = strtemp.substring(0,selstart) + buff + strtemp.substring(selend,strtemp.length());
				textarea.setText(temp2);			
			}
		});

		mnuexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});


		mnunew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				textarea.setText("");
			}
		});


		//open a file
		mnuopen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){

				filepath = "";
				filedialog.setMode(FileDialog.LOAD);
				filedialog.show();
			
				if(!(filedialog.getDirectory()==null)){
					filepath = filedialog.getDirectory().replace((char)(92),'/');
					filepath += filedialog.getFile();					

					String str ="";
					textarea.setText("");
		
					try{
						FileInputStream fin = new FileInputStream(filepath);
						BufferedReader br = new BufferedReader(new InputStreamReader(fin));

						while((str = br.readLine())!=null)
							textarea.setText(textarea.getText() + "\n" + str);
					}
					catch(IOException ie){
						ie.printStackTrace();
					}									
				}				
			}
		});

		mnusave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				filepath = "";	
			
				filedialog.setMode(FileDialog.SAVE);
				filedialog.show();

				if(!(filedialog.getDirectory()==null)){
					filepath = filedialog.getDirectory().replace((char)(92),'/');
					filepath += filedialog.getFile();

					String str = "";

					try{
						FileOutputStream fout = new FileOutputStream(filepath);
						PrintStream pr = new PrintStream(fout);

						pr.print(textarea.getText());											
					}
					catch(IOException ie){
						ie.printStackTrace();
					}
				}				
			}
		});
	
	}


	public static void main(String args[]){
		new Notepad().setVisible(true);	
	}
}
