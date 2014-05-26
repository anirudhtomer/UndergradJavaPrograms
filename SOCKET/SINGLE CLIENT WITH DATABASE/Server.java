import java.net.*;
import java.io.*;
import java.sql.*;

class Server{

	ServerSocket serversocket = null;
	Socket clientsocket = null;
	BufferedReader brserver,brclient;
	PrintStream prclient;

	String clientstr = "",serverstr = "";
	Connection con;
		
	private void connectDatabase(){
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			con = DriverManager.getConnection("jdbc:odbc:tomer","system","root");
			//u guys have to make your own connection at ur control panel
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public Server(){
		
		connectDatabase();


		try{

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			//write it in the sequence "TYPE_SCROLL_SENSITIVE & then CONCUR_UPADATABLE....else u'll invalid cursor state on query
			/* guys our college sucks...u knw 

				if they ask u to use oracle then...
		
				Statement st = con.createStatement();
				would be sufficient...even in Access 2007 it works
				but at college we have Access 2003

				so pray to get oracle 9i		
			*/

			serversocket = new ServerSocket(5000);
			while(true){
				
				clientsocket = serversocket.accept();

				System.out.println("CLIENT ATTACHED TO " + clientsocket.getInetAddress() + " at port " + clientsocket.getPort());	
		
				brclient = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				brserver = new BufferedReader(new InputStreamReader(System.in));
				prclient = new PrintStream(clientsocket.getOutputStream());
	
				serverstr = "U R ATTACHED TO " + clientsocket.getInetAddress() + " at port " + clientsocket.getPort();
		
				prclient.println(serverstr);
	
				while(true){	
								
					clientstr = brclient.readLine();		
		
					System.out.println("CLIENT :-\t" + clientstr);
					
					//put in database

					st.executeUpdate("insert into serverchat values (" + clientsocket.getPort() + ",'" + serverstr + "','" + clientstr + "')");
	
					if(clientstr.equalsIgnoreCase("BYE")){
						prclient.println("" + clientsocket.getPort());
						st.executeUpdate("insert into serverchat values (" + clientsocket.getPort() + ",'K BYE MAN','BYE')");
						break;
					}
			
					System.out.print("TYPE KAR BHAI::\t");

					serverstr = brserver.readLine();
				
					prclient.println(serverstr);						
			
				}		
	
				clientsocket.close();
				clientsocket = null;


			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
	}
	public static void main(String args[]){
		new Server();
	}
}

