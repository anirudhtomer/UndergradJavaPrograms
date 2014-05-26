// "synchronization" in multithreading using "synchronized object"

//in c or c++ if for delay(100) is given then till 100ms for one isn't over new process does start(while java shares time by multithreading) this is called synchronization



class thrd 
{

    void indr_run(String msg)
    {
        System.out.print(" [" + msg);

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            System.out.println("INTERRUPTED SYSTEM");    
        }
        System.out.print("] ");

    }
}

class extr implements Runnable
{
    Thread t;
    thrd cmn;
    String str;

    extr(String str,thrd tr)
    {
        cmn = tr;
        this.str = str;
        t = new Thread(this,str);
        t.start();
    }

 /*
    in the prevoius program we used synchronized method but it isn't necessary that
    that everytime the change of methods from non-synchronized to synchonized is in our hands
    as sometimes we import the files too.

    at that time we make the object of that class synchronized because the handling of objects is in our hands
 */

    public void run()
    {
        synchronized(cmn)
        {
            cmn.indr_run(str);
        }
    }

}

//MUST MUST READ THE FOLLOWING
/*
     remove "synchronized" & see what changes happen to the o/p & how much time is consumed.

     to show use of synchronization the "class thrd" is needed because synchronization
     is about sharing a common resource. if i use only the class extr & use three different
     threads in it then every thread has it's own "public void run()" function & thus switching takes place
     b/w the threads.

     but if i use a cmn object object of "class thrd" & call "indr_run" function for all threads
     then as the object is same the following things happen::

     (  common resource is called "moniter" which is object "cmn" here )

     1. without "synchronized keywd"....time sharing takes place b/w threads & due to switching 
                                net time taken by all threads = time delay for each thread = 10000ms(here)

     2. with "synchronized keywd"....till delay for one thread isn't over or till the run() function is not over (run uses the source i.e object "cmn" here)
                                     control isn't transferred to other thread & thus the
                                net time taken = sum of the delay for each thread = 30000ms (here)

     remember it's necessary to use to common resorce (like the object "cmn" here) to implement sychronization.   

*/

  
class synchronisation2
{
    public static void main(String args[])
    {

        thrd x = new thrd();  //common resource for all three threads

        extr t1 = new extr("THREAD ONE",x);
        extr t2 = new extr("THREAD TWO",x);
        extr t3 = new extr("THREAD THREE",x);

        try
        {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("MAIN INTERRUPTED SYSTEM");    
        }

        System.out.println();

    }

}
