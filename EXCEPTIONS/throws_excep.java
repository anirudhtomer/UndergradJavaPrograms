//PROGRAM TO SHOW USE OF "throws"

/*
    to throw an exception from a function to calling function
    we do it using "throw" .
    put a "try-catch" in that function.... create your own exception object
    handle it & rethrow to calling function...
    calling function also has a "try catch"   (seek previous program)


    now we can use "throws" instead of "throw"
    using "throws" we need to implement "try-catch" in the function which is being called
    we just have to tell the calling function the kind of exception called function may throw
    the following example implements that.
*/



class throws_excep
{
    public static void main(String args[])
    {
        try
        {
            throwsfunc();
        }
        catch(IllegalAccessException err)  
        {
            System.out.println(err);    
        }

    }


    static void throwsfunc() throws IllegalAccessException   
	//if u throw any other exception error comes....if u write only "Exception" here then u can throw anything but remember then u have to write "catch(Exception ..)" in the calling function....thus making everything generalized
    {
        System.out.println("\nINSIDE THROWS FUNCTION");
        throw new IllegalAccessException();  //default constructor

        //u could have used " throw new IllegalAccessException("HELLO");  //parametrized constructor


    }


}

