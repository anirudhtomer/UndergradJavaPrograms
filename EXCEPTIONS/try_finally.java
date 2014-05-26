//PROGRAM TO SHOW USE OF "finally"


/*  while u throw an exception by a "try-catch" inside the try block then
    the code just after the "statement at which exception is produced"
    is not executed....this way u may something important to be executed
*/


//try always has a "catch" or "finally" or both

//the finally is always executed just even if appropriate catch is not found
//even if "return" is written before try or even no exception is thrown then also the "finally" will be executed



class try_finally
{
    public static void main(String args[])
    {
            
        try
        {
            throw1();
        }
        catch(Exception err)
        {
            System.out.println("\nTHE THROW1 IS CAUGHT IN MAIN");
        }

        throw2();

    }

    static void throw1()
    {
        try
        {
            throw new ArithmeticException("arth");
            //return; //unreachable code
        }
        catch(ArithmeticException e)
        {
            System.out.println("HI IAM CATCH IN THROW1");  

            throw e; //rethrow to calling method
        }

        finally
        {
            System.out.println("\nTHIS IS FINALLY BLOCK OF THROW1");
            
        }

        
    }

    static void throw2()
    {
        try
        {
            System.out.println("\nTHIS IS TRY BLOCK OF THROW2");
            return;
        }
        finally
        {
            System.out.println("\nTHIS IS FINALLY BLOCK OF THROW2");
        }



    }

}
