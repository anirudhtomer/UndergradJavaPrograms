//PROGARAM TO SHOW HOW TO PASS "VARIBLE NUMBER OF ARGUMNETS TO A FUNCTION"

/* suppose i wanna pass 1/2/3  no.s of integers to a method which does a similar work for all of them
   i can use overloaded function for these
   e.g  void ani(int) / void ani(ini,int) /void ani(int,int,int)...till the no of arguments are quite small & known

   also i can pack all values in an array & then pass to a function
   e.g void ani(int v[]) .....(tedious job to pack the values)
   
   the most efficient way is java's "varargs" way which is implemented by following program
*/


class varargs
{

    varargs(){}
    

    //  "int...arr" here ellipses(...) tells the compiler that the number of arguments are varible & thus put all values in an array

    void func(double p,int...arr) //the argument "int...arr" should be the last
    {
        System.out.println("\nTHE NUMBER OF ARGUMENTS ARE:-\t" + arr.length);

        for(int x:arr)
        {
            System.out.println("\n:-\t" + x);
        }

    }

    void func(double x)
    {
        System.out.println("\n\nTHE REAL VALUE PASSED IS :-\t" + x);

    }


    /* there is an ambiguity between the above two functions when any double value is passed to them
       i don't know how compiler resolves it */


}


class var_argu
{
    public static void main(String args[])
    {

        int i = 45;
        varargs v1 = new varargs();


        v1.func(10.2);
        v1.func(1,2,5,i);        



    }
}
