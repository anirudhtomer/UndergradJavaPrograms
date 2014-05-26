// BASICS OF THREADING

/*  two types of multitaskings are:

    1. PROCESS BASED:-  playing winamp & writing program in java together
    2. THREAD BASED:- song is getting played in winamp & u change the skin of winamp

    thus a thread is a part of program....program can execute many parts/threads together
    OS executes many processes/programs together

*/

//A THREAD IS A CLASS & it's objects are needed to be created
//as soon as a program starts the "main thread" starts running.....all threads are it's branches & it's execution gets over at last


class basic_thread
{
    public static void main(String args[])
    {
        Thread t = Thread.currentThread();  //static Thread currentThread();...thus called by class name directly

        System.out.println("\nTHE CURRENT THREAD IS:-\t" + t);

        t.setName("anirudh"); //changes the name of thread from "main" to "anirudh"   "final void setName(String.."); 

        System.out.println("\nTHE CURRENT THREAD IS:-\t" + t);

        String str = t.getName();  //function to get name of the thread...."final String getName();"

        System.out.println("\nTHE NAME OF THE CURRENT THREAD IS:-\t" + str);


        //it is necessary (else u get error at compile time) to put in "try-catch" so that if anything interrupts it then "try-catch" handles it

        try
        {
           for(int i =0;i<10;i++)
            {
                System.out.print("\n" + i);
                Thread.sleep(500);  //work as a delay
            }
        }

        catch(InterruptedException err)
        {
            System.out.print("\nINTERRUPTED EXCEPTION OCCURS");

        }
    }
}
