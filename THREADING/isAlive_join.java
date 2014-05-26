//USING "isAlive()" & "join()"

/*
    the "final boolean isAlive()" function returns either "true" or "false"
    "true":- thread is currently working
    "false" :- working of thread is over

    thread gets alive only when "start()" call is given & gets over when "run()  or the thread" is over


    the other important function is "final void join()throws InterruptedException"

    instead of making the "main thread" to wait we use this function

    this function makes the system to wait until the thread is over
    thus it makes sure that "main thread" is not gonna get over
    before the completion of the thread for which join is called

    ***SAR**:-  if i write Thread.sleep(time) & if the time is


                1.small then main thread gets over & other threads are still working
                2. too big makes the system to wait unnecessarily even if all threads are over

                thus "join()" provides "just enough" delay to the system & makes the system to wait until the thread is over

    REMEMBER "Thread" is a kind of "process"
*/

class nthr implements Runnable
{
    Thread t;        

    nthr(String str)
    {
        System.out.println(str + " is INITIALIZED");

        t = new Thread(this,str);

        t.start();

    }

    public void run()
    {
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println(t.getName() + ":-\t" + i);
                t.sleep(100);
            }
        }

        catch(InterruptedException er)
        {
            System.out.println(t + " is interrupted");
        }

    }

}

class isAlive_join
{
    public static void main(String args[])
    {
        nthr thr1 = new nthr("ONE");
        nthr thr2 = new nthr("TWO");
        nthr thr3 = new nthr("THREE");

        System.out.println("THREAD ONE IS ALIVE:-\t" + thr1.t.isAlive());
        System.out.println("THREAD TWO IS ALIVE:-\t" + thr2.t.isAlive());
        System.out.println("THREAD THREE IS ALIVE:-\t" + thr3.t.isAlive());
        
        try
        {
            thr1.t.join();
            thr2.t.join();
            thr3.t.join();
        }

        catch(Exception e) // or "InterruptedException e"
        {
            System.out.println("THE EXCEPTION IS :-\t" + e);            
        }

        System.out.println("THREAD ONE IS ALIVE:-\t" + thr1.t.isAlive());
        System.out.println("THREAD TWO IS ALIVE:-\t" + thr2.t.isAlive());
        System.out.println("THREAD THREE IS ALIVE:-\t" + thr3.t.isAlive());



            
    }
}
