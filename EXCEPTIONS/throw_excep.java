//PROGRAM TO SHOW USE OF "throw"

//you can't throw " int,float,double....or classes like Object...........can pass a string

/* in the prevoius program we used to catch the system's exception & replace them with our own
    here & create the system's exceptions forcefully & print them */

//you can replace the whole error using  "try-catch" but can't change the error statement.....u can't change that unless u create ur own exception object & pass a string as a parameter to it.

/* "throw" checks all the nearest catches one by one to
    check whether the exception type matches....if not then JRTS halts & prints
    the "STACK TRACE" of the error

    STACK TRACE:-  if u call a function & an exception occurs in that function then
                   system prints error in the format

                   error, line on which it occurs, function in which it occurs.
                   (this is not the exact format but is just to understand...actual format is quite different)


                   since every function is called by another function & finally "main" is the ancestral source 
                   JRTS pops the stack & shows the shows error statements in the above format
                   for all those functions which called the error containing function in hierrachy.

                   i mean to say if "main" called "hero" & hero called "gravity"
                   & gravity contains error then system pops the stack to show

                   error at gravity,hero & main & since they called each other to to produce the error.

                
*/

// all exceptions are objects


class throw_excep
{

    //this functions rethrows the error to main
    static void rethrowfunc()
    {
       try
       {
			String s = "HELLO I HAVE REPLACED THE EXCEPTION\n DEFINITION WITH THIS DEFINTION";
            //new exception object of class "ArithmeticException" is created & a string is passed to it as a parameter & then it is thrown to JRTS              
            ArithmeticException excep = new ArithmeticException(s);
			
			throw excep;
			// we could have directly thrown by "throw new ArithmeticException(s)";
            //we can create any exception any time....it's my life & i can do what i want

       }
       catch(ArithmeticException err)
       {
            System.out.println("HI IAM ANIRUDH");

            throw err;//error rethrown to calling function
       }

       //don't write throw here because "err" varible's scope ends at above curly brace

    }

    public static void main(String args[])
    {
        try
        {
            rethrowfunc();
        }

        catch(ArithmeticException err)
        {

            System.out.println("\n\nRETHROWN ERROR (iam in main) :-\n\n" + err);
        }

    }

}



