//USING MULTITHREADED SYSTEM

//make the "main thread" to sleep long enough,so that it may terminate at last
//after seeing the output u will realize that all threads are executed concurrently    

class nthr implements Runnable
{
    Thread t;

    nthr(String str)
    {
        t = new Thread(this,str);        
        
        System.out.println("\nINITIALISING THREAD :-\t" + t.getName() );

        t.start();
    }


    public void run()
    {
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println(t.getName() + ":-\t" + i);
                t.sleep(200);
            }
        }
        catch(InterruptedException er)
        {
            System.out.println("\nThread " + t.getName() + " Interrupted");
        }

        System.out.println(t.getName() + " Is Over");
        
    }

}


class multithread
{
    public static void main(String args[])
    {
        new nthr("ONE");
        new nthr("TWO");
        new nthr("THREE");

        try
        {
            Thread.sleep(1100);
        }
        catch(InterruptedException er)
        {
            System.out.println("\nThread " + Thread.currentThread().getName() + " Interrupted");
        }

        System.out.println(Thread.currentThread().getName() + " Is Over");

    }
}
