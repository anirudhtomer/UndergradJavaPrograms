
class bhalla{

	int n;
	boolean flag = false;

	synchronized  public void get(){
            System.out.println("thread2 in get()");
		while(!flag){
			try{
                        System.out.println("wait2");
				wait();
			}
			catch(Exception e){

			}
		}


		System.out.println("GET:: " + n);
		flag = false;
                System.out.println("notify1");
		notify();
	}

	synchronized  public void put(){
                System.out.println("thread1 in put()");
		while(flag){
			try{
                            System.out.println("wait1");
				wait();
			}
			catch(Exception e){

			}
		}

		n++;
		System.out.println("PUT::  " + 	n);
		flag = true;
                System.out.println("notify2");
		notify();

	}


}

class dalla implements Runnable{
	bhalla b2;

	Thread t;

	public dalla(String tname,bhalla bh){
		t = new Thread(this,tname);
		t.start();
		b2 = bh;
	}

	public void run(){

		while(true){
			if(t.getName().equals("ONE")){
				b2.put();
			}
			else{
				b2.get();
			}
		}
	}

	public static void main(String args[]){

		bhalla b1 = new bhalla();
		dalla d1 = new dalla("ONE",b1);
		dalla d2 = new dalla("TWO",b1);

		try{
			d1.t.join();
			d2.t.join();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("kam khatam");


	}
}
