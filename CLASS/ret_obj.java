//progarm to show "how to return an object" in java

/* till and untill atleast one reference is present to a memory location
 that memory is not taken into consideration for garbage collection*/


class ref_val
{
    int a,b;


    ref_val(int a,int b)
    {
        this.a = a;
        this.b = b;
    }


    ref_val getnew(int p,int q)
    {
        ref_val obj = new ref_val(p,q);

        return obj;
    }

    /*the scope of the "getnew" method ends here so memory referenced by obj
       should be released....but another refernce in "main" method is ready
       to collect it so it is not released */

    void showval()
    {
        System.out.println("\nTHE VALUE OF \"a\" is:-\t" + a);
        System.out.println("\nTHE VALUE OF \"b\" is:-\t" + b);
    }
 }

class ret_obj
{
    public static void main(String args[])
    {

        ref_val ob1 = new ref_val(100,200);
        ref_val ob2;


        //ob2.showval(); //it shows the error that reference is not initialized

        ob2 = ob1.getnew(10,20);   //now reference variable has been given a memory space to work upon

        ob2.showval();

    }
}
