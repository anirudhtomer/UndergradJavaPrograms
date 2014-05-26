//PROGRAM TO SHOW EXCEPTION HANDLING

//by using exception handling program does not halt even after the exception occurs

//every exception is an object & when JRTS prints it it makes a new object of that type of exception. 
//since every exception is an object they have constructors :---   1. default		2.parametrized
//default constructor automatically tells the what the exception is
//parametrized take the exception foem us & then puts it on the screen 
//to know more about the above two statements open the program throw.java

    
class try_catch
{
    public static void main(String args[])
    {
        exceptionhandle(args.length);
        System.out.println("IAM BACK TO MAIN");
    }

    static void exceptionhandle(int len)  //since main is static thus only static member functions can be called from it
    {

    /*
        Suppose i don't know if the following code produces errors & i don't want my program to halt due a stupid single error
        then i put that code in a try block.
        u should know what kind of exception(not error because errors & exceptions are different)
        it may produce

        e.g.

        1.ArithmeticExceptionError
        2.ArrayIndexOutOfBoundsException
        3.NullPointerException	

        if u don't know the kind of exception then also it's Ok..u can use the
        word "Exception" which is the super class of the all different kinds of Exceptions

        now write a catch after a try.
        there can be multiple catches for a try....however there can't be more than one catches trying to catch the same kind of exception

        e.g     try
                {
                 ....
                }
                                                         
                catch(Exception err)
                {
                ...
                }
                catch(Exception frp)
                {
                ...
                }

                is not right as both catches try to catch the same kind of exception
	     			
	     if no catch is found in the function then JRTS returns to prevoius function & checks in that & returns to all prevoius functions till a catch is found...	
	     every try must have a catch	& if appropriate catch is not found then JRTS automatically prints the exception but every try must have a catch(dosen't matter if an inappropriate catch is given)	

    */

        try
        {
            int x = 2/len;  //produces divide by zero exception if len=0;

            int a[] = {9};

            a[20] *= 2;  //produces array index out of bounds error

        }

        catch(ArithmeticException divzero)
        {
            System.out.println("\nHELLO THIS IS A DIVIDE BY ZERO EXCEPTION & IF YOU WANNA GET ANOTHER KIND OF \nEXCEPTION THEN SEND A COMMAND LINE ARGUMNET THE NEXT TIME\n");
        }

        catch(Exception gen_err)// not executed as only one exception was produced which was handled by previous catch
        {
            System.out.println("\nHELLO THIS IS A GENERAL EXCEPTION...the specified exception is:-\n" + gen_err);  //u can even print the "java's form" of the error by printing the argument
        }

        /* suppose u pass a command line argument to the main then args.length becomes > 0 which
           is passed to this function as "len" which when divide 2 does not produce any exception

           now size of array "a" is 1 & we try to access 20th element thus an exception is produced
           since first catch can catch only "div by 0" thus the exception is forwarded to next catch
           which has the ability to catch all types of exception
            
           thus the following catch is of no use even if i write it (it produces error on writing)
           & is unreachable & thus JRTS produces errors for it.

            catch(ArrayIndexOutOfBoundsException arr_err)
            {
              System.out.println("\nYOU TRIED TO ACCESS AN INDEX GREATER THAN SIZE OF ARRAY");
            }


         */

        System.out.println("ERROR AAYA TO KYA HUA..LET'S CARRY ON MAN!");

    }

}
