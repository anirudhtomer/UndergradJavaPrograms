import java.net.*;
import java.io.*;

class Client{

	Socket clientsocket;
	BufferedReader brserver,brclient;
	PrintStream prclient;

	String clientstr = "",serverstr = "";


	public Client(){

		try{
	
			clientsocket = new Socket("localhost",5000);

			brserver = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			brclient = new BufferedReader(new InputStreamReader(System.in));
			prclient = new PrintStream(clientsocket.getOutputStream());
	

			while(true){	
								
				serverstr = brserver.readLine();		
		
				System.out.println("SERVER :-\t" + serverstr);

				if(clientstr.equalsIgnoreCase("BYE"))
					break;

				System.out.print("TYPE BUDDY::\t");
				clientstr = brclient.readLine();
				
				prclient.println(clientstr);						
			
			}		

			clientsocket.close();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	}
	
	public static void main(String args[]){
		new Client();
	}
}

