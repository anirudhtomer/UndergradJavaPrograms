import java.net.*;
import java.io.*;

class HandleSynchro{

	int clientno = 0;

	
	synchronized public void chat(HandleClient handleclient,Socket clientsocket,BufferedReader brclient,BufferedReader brserver,PrintStream prclient,String clientstr,String serverstr){
				try{
					
					while(clientno==clientsocket.getPort()){
						wait();
					}
					
					System.out.print("TYPE FOR CLIENT " + clientsocket.getPort() + "::\t");

					serverstr = brserver.readLine();
					System.out.println("killa out" + clientsocket.getPort());
				
					prclient.println(serverstr);			

					clientno = clientsocket.getPort();
					notifyAll();
								
				}
				catch(Exception e){
					e.printStackTrace();
				}

	}
}


class HandleClient implements Runnable{

	Socket clientsocket;
	BufferedReader brserver,brclient;
	PrintStream prclient;
	HandleSynchro handlesynchro;

	String clientstr = "";
	String serverstr = "";

	boolean stopflag = false;

	Thread t;
	
	public HandleClient(Socket clientsocket,HandleSynchro handlesynchro){
		this.clientsocket = clientsocket;
		this.handlesynchro = handlesynchro;

		t = new Thread(this,"" + clientsocket.getPort());
		t.start();
	}

	public void run(){
		try{
			System.out.println("CLIENT ATTACHED TO " + clientsocket.getInetAddress() + " at port " + clientsocket.getPort());	
		
			brclient = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			brserver = new BufferedReader(new InputStreamReader(System.in));
			prclient = new PrintStream(clientsocket.getOutputStream());
	
			serverstr = "U R ATTACHED TO " + clientsocket.getInetAddress() + " at port " + clientsocket.getPort();
		
			prclient.println(serverstr);
	
			while(!stopflag){	
				System.out.println("killa in" + clientsocket.getPort());
				clientstr = brclient.readLine();		
		
				System.out.println("CLIENT " + clientsocket.getPort() + ":-\t" + clientstr);

				if(clientstr.equalsIgnoreCase("BYE")){
					prclient.println("" + clientsocket.getPort());
					stopflag = true;
				}
			
				handlesynchro.chat(this,clientsocket,brclient,brserver,prclient,clientstr,serverstr);								
			}
			
			clientsocket.close();
			clientsocket = null;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}


class Server{

	ServerSocket serversocket = null;
	Socket clientsocket = null;
	HandleSynchro handlesynchro = new HandleSynchro();
	

	public Server(){
		
		try{
			serversocket = new ServerSocket(5000);
			while(true){
				clientsocket = serversocket.accept();
				new HandleClient(clientsocket,handlesynchro);
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
