import java.net.*;
import java.io.*;
import java.sql.*;

class Client{

	Socket clientsocket;
	BufferedReader brserver,brclient;
	PrintStream prclient;

	String clientstr = "",serverstr = "";

	Connection con;

	private void connectDatabase(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:tomer","system","root");					
		}
		catch(Exception e){
			e.printStackTrace();	
		}
	}
		
	public Client(){

		connectDatabase();

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

			System.out.println("\n\n\nTHE COMPLETE CHAT DETAILS RETEIEVED FROM DATABASE ARE::\n\n\n");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet rst = st.executeQuery("select * from serverchat where clientport = " + Integer.parseInt(serverstr.trim()));
			
			while(rst.next()){
				System.out.println("SERVER SAID: " + rst.getString("server"));
				System.out.println("CLIENT SAID: " + rst.getString("client"));		
			}
						
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

