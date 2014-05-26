//THREAD PRIORITIES

/*
    range of priority .... 1-10

    MIN_PRIORITY :- 1
    NORM_PRIORITY :- 5
    MAX_PRIORITY :- 10

    functions for priority
    1. final void setPriority(int priority)
    2. final int getPriority()

*/


class prior implements Runnable
{
    long cnt = 0;
    Thread t;
    boolean running = true;

    prior(int p,String str)
    {
        t = new Thread(this,str);    
        t.setPriority(p);
        t.start();
    }

    public void run()
    {
        while(running)
        {
           System.out.println(t.getName() + "  " ); 
           cnt++;
        }

    }

    void showcnt()
    {
        System.out.println("\nTHE COUNT VALUE FOR \"" + t.getName() + "\" is :-\t" + cnt);
    }

}


class priority
{
    public static void main(String args[])
    {
        prior p1 = new prior(Thread.MIN_PRIORITY,"THREAD min");
        prior p2 = new prior(Thread.MAX_PRIORITY,"THREAD max");
        
        try
        {
            Thread.sleep(1000);   //as soon as it comes out of sleep variable "running" becomes "false"

            /* don't do the mistake to put "join()" here as running is "true" int "run method"
               & main thread never gets a chance to come back & system goes in infinite loop */ 
        }

        catch(Exception e)
        {

        }

        p1.running = false;
        p2.running = false;

        try
        {
            p1.t.join();
            p2.t.join();

            // join is written here so that even if time of "1000 ms " is not sufficient then join makes the "main therad" to wait till the specified thread is over
        }

        catch(Exception e)
        {

        }
        //if i don't put this try-catch block here then showcnt() is executed first & child threads are executed later

        p1.showcnt();
        p2.showcnt();

        if(p1.cnt < p2.cnt)
        {
            System.out.println("\nTHUS THREAD WITH MAX PRIORITY IS EXECUTED MORE TIMES");
        }

        else
        {
            System.out.println("\nTHUS EITHER A FUCKING CHANGE IS MADE BY U OR I DON'T KNOW HAS HAPPENED");
        }


    }
}
