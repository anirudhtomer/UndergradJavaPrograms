import java.io.*;

public class Macro{

	String [][] source = new String[30][30];
	int totallines;
	int sourceindex;

	class MDT{
		int mdtindex;
		String mdtstr;		
	}

	class MNT{
		int mntindex;
		String macroname;
		int mdtindex;
	}

	class ALA{
		String alaindex;
		String dummyarg,actarg;
		int mntindex;
	}

	MDT []mdt = new MDT[30];
	MNT []mnt = new MNT[5];
	ALA []ala = new ALA[20];

	int curmdtindex = 0,curmntindex = 0,curalaindex = 0;
		
	public Macro(){
	
		for(int i=0;i<30;i++)
			mdt[i] = new MDT();
		
		for(int i=0;i<5;i++)
			mnt[i] = new MNT();
		
		for(int i=0;i<20;i++)
			ala[i] = new ALA();
		
				

		readSource();
		pass1();
		displayPass1Result();
		pass2();
	
	}
	
	public static void main(String args[]){
		new Macro();	
	}

	//PASS1
	private void pass1(){
		
		int flag = 0;  
		int lastalaindex = 0;
	
		/*
		 * 0-search for MACRO or START 				
		 * 1-MACRO detected copy it in ala 	
		 * 2-copy macro in mdt & look for MEND
		*/
		
		int i,j;
		for(i=0;i<totallines;i++){
			j=0;	
			
			//look for macro
			if(flag==0){
				if(source[i][j].equalsIgnoreCase("MACRO")){
					flag = 1;	
				}
			
				else if(source[i][j].equalsIgnoreCase("START")){
					break;		
				}
	
			}
		
			//macro detected copy in ala
			else if(flag==1){
		
				//put entry in MNT
				mnt[curmntindex].mntindex = curmntindex;
				mnt[curmntindex].macroname = source[i][0];
				mnt[curmntindex].mdtindex = curmdtindex;						
				curmntindex++;
				
				lastalaindex = curalaindex;
				//put entry in ALA
				for(int p=1;!source[i][p].equalsIgnoreCase("");p++){
					ala[curalaindex].alaindex = "#" + curalaindex;
					ala[curalaindex].dummyarg = source[i][p];	
					ala[curalaindex].actarg = "";
					ala[curalaindex].mntindex = curmntindex-1;
					curalaindex++;
					
				}

				//put the 1st entry in MDT too
				mdt[curmdtindex].mdtindex = curmdtindex;
				mdt[curmdtindex].mdtstr = source[i][0] + " ";
	
				for(int p=lastalaindex;p<curalaindex;p++){
					mdt[curmdtindex].mdtstr += "#" + p + " ";
				}
				curmdtindex++;

				flag = 2;
	
			}
			//copy in mdt & look for MEND
			else if(flag==2){
				if(source[i][0].equalsIgnoreCase("MEND")){
					mdt[curmdtindex].mdtindex = curmdtindex;
					mdt[curmdtindex].mdtstr = source[i][0];
					curmdtindex++;
					flag = 0;					
				}
				else{
					mdt[curmdtindex].mdtindex = curmdtindex;
					mdt[curmdtindex].mdtstr = "";
	
					for(int p=0;!source[i][p].equalsIgnoreCase("");p++){
						boolean passed = true;
						for(int q=lastalaindex;q<curalaindex;q++){
							if(ala[q].dummyarg.equalsIgnoreCase(source[i][p]))
							{
								mdt[curmdtindex].mdtstr += ala[q].alaindex + " ";
								passed = false;
								break;
							}

						}
						if(passed)
							mdt[curmdtindex].mdtstr += source[i][p] + " ";
					}

					curmdtindex++;
				}						
			}	

		}			
		sourceindex = i;

	}

	//PASS2 
	private void pass2(){

		try{
			int i;
			FileOutputStream fout = new FileOutputStream("macroexpand.txt");
			PrintWriter pw = new PrintWriter(fout,true);

			for(i=sourceindex;i<totallines;i++){

				boolean passed = true;

				for(int q=0;q<curmntindex;q++){
					
					if(source[i][0].equalsIgnoreCase(mnt[q].macroname)){

						int cnt = 1;
						
						//change the actual arg in ALA
						for(int j=0;j<curalaindex;j++){
							if(ala[j].mntindex==q){
								ala[j].actarg = source[i][cnt++];
							}				
						}
						
						//now read MDT and ALA together & put it in the file
						for(int b=mnt[q].mdtindex + 1;!mdt[b].mdtstr.equalsIgnoreCase("MEND");b++){
							String tempmdtstr = mdt[b].mdtstr;
							
							for(int j=0;j<curalaindex;j++){
								if(ala[j].mntindex==q){
									tempmdtstr = tempmdtstr.replaceAll(ala[j].alaindex,ala[j].actarg);
								}
							}	
							pw.println(tempmdtstr);			
						}
						
							


						passed = false;
						break;
					}
				}
				
				if(passed){
					for(int p=0;!source[i][p].equalsIgnoreCase("");p++){
						pw.print(source[i][p] + " ");
					}
					pw.println();
				}			
	
			}

		}
		catch(Exception ie){
			System.out.println("Exception in pass2()" + ie.getMessage());
			ie.printStackTrace();			
		}
	
	}
	

	//displayPass1Results
	private void displayPass1Result(){

		System.out.println("\n\n********* MDT IS ********\n\n");
		for(int i=0;i<curmdtindex;i++){
			System.out.println(mdt[i].mdtindex + "  " + mdt[i].mdtstr);
		}

		System.out.println("\n\n********* MNT IS ********\n\n");
		for(int i=0;i<curmntindex;i++){
			System.out.println(mnt[i].mntindex + "  " + mnt[i].macroname + "  " + mnt[i].mdtindex);
		}

		System.out.println("\n\n********* ALA IS ********\n\n");
		for(int i=0;i<curalaindex;i++){
			System.out.println(ala[i].alaindex + "  " + ala[i].dummyarg);
		}

	}

	//read the source to seperate tokens
	private void readSource(){
		try{
			String str;
		
			FileInputStream fin = new FileInputStream("macrosource.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			
			int i=0;
			int j=0;
			totallines = 0;

			while( (str=br.readLine())!=null){
				
				str = str.trim();
				
				str = str.replaceAll(","," ");
				for(int m=0;m<5;m++)
					str = str.replaceAll("  "," ");
				
				if(!str.equalsIgnoreCase("")){
					
					j=0;
					String str2 = "";
					str = str + " ";
					for(int p = 0;p<str.length();p++){
					
						if(str.charAt(p)!=' ')
							str2 += str.charAt(p);
						else{
							source[i][j++] = str2;
							str2="";
						}						
					}
					source[i][j]="";					
					i++;
					totallines++;
				}
	
			}

			for(int p=0;p<totallines;p++){

				for(int k=0;!source[p][k].equalsIgnoreCase("");k++)
					System.out.print(source[p][k] + " ");
				System.out.println();
			}

			fin.close();

		}
		catch(Exception ie){
			System.out.println("Exception in readSource()" + ie.getMessage());
			ie.printStackTrace();			
		}
	}
}