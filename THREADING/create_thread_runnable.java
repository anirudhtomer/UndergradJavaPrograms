//CREATTION OF THREAD BY "runnable interface"

/*
    "Runnable" is an "interface " & "run" is a method in it
    which is to be overridden by any class (obviously)

    so whatever u write in the run method is a "Thread (thread is a part of program)"

    "Thread" is a class & we have to instantiate it.
    it's constructor is

    "Thread(Runnable name of object,String name of thread);"

    since the "interface Runnable" act as a super class for the class which implements it
    we pass a object of type class & "Runnable" can reference to it (superclass can reference to a sub-class object)
    thus i have written the type of object as "Runnable" instead of "class name" but u pass an object of the type of class
*/


/* EXPLANATION OF THE PROGRAM

    as soon as a new instance of class alpha is creted it's constructor is called which
    starts the method "run" & control returns back to main
    the for loop in the main has a dely of 1000 ms in it.
    the processor instead of keeping silent processor the second thread i.e the run method

    the run method also has a delay of 200 ms & after running five times it gives control back to main thread
    which again return control to this thread at next sleep & the same process continue till both therad are executed

    here in run method if would had given a delay of 2000 ms then main process would have got over earlier
    as it has lesser loops & lesses delay

    however main threads gets over at last.
*/


class alpha implements Runnable
{
    Thread t;

    String str;

    alpha(alpha obj)
    {
        str = "Parametrized alpha MY thread";

        t = new Thread(obj,str);

        t.start();
    }

    alpha()
    {
        str = "default MY alpha thread";
        t = new Thread(this,str);
        t.start();

    }

    public void run()     //all overidden interface methods are public
    {
        try
        {
            for(int i=0;i<25;i++)
            {
                System.out.println(t.getName() + ":\t" + i);
                Thread.sleep(200);  //static method
            }
        }

        catch(InterruptedException er)
        {
            System.out.println("INTERRUPTED PROCEDURE");

        }

    }
    


}

class create_thread_runnable
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
