//CREATTION OF THREAD BY "extending Thread class"


/* EXPLANATION OF THE PROGRAM

    we can create a sub-class of "Thread class"

    as soon as a new instance of class alpha is creted it's constructor is called which
    starts the method "run" & control returns back to main
    the for loop in the main has a dely of 1000 ms in it.
    the processor instead of keeping silent processor the second thread i.e the run method

    the run method also has a delay of 200 ms & after running five times it gives control back to main thread
    which again return control to this thread at next sleep & the same process continue till both therad are executed

    here in run method if would had given a delay of 2000 ms then main process would have got over earlier
    as it has lesser loops & lesses delay

    however main threads gets over at last.


    usually the method to implement an interface is chosen
*/


class alpha extends Thread
{

    alpha()
    {
        super("my thread"); //constructor of super class takes the string & no object

        start(); //start now becomes it's integral part due to inhertance

    }

    public void run()     
    {
        try
        {
            for(int i=0;i<25;i++)
            {
                System.out.println(getName() + ":\t" + i);
                Thread.sleep(200);  //static method
            }
        }

        catch(InterruptedException er)
        {
            System.out.println("INTERRUPTED PROCEDURE");

        }

    }
    


}

class creat_thred_extnd_Thred
{
    public static void main(String args[])
    {
        new alpha();

        Thread x = Thread.currentThread();

        try
        {
            for(int i=0;i<4;i++)
            {
                System.out.println(x.getName()+ ":-\t" + i);
                Thread.sleep(1000);  //static method
            }
        }

        catch(InterruptedException er)
        {
            System.out.println("INTERRUPTED PROCEDURE");

        }
        
    }

}
