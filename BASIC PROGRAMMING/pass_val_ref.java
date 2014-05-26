//progarm to show "call by reference" & "call by value" in java


//primitive types are passed by value
//objects are passed by reference internally


class ref_val
{
    int a,b;


    ref_val(int a,int b)
    {
        this.a = a;
        this.b = b;
    }


    void chngval(int x,int y)  //primitive type are passed by value
    {
        x = x*2;
        y = y/2;

    }


    void chngval(ref_val obj1) //objects are passed by reference
    {
        obj1.a *= 2;
        obj1.b /= 2;
    }

}

class pass_val_ref
{

    public static void main(String args[])
    {
        int num1 = 100,num2 = 200;

        ref_val ob1 = new ref_val(10,20);


        System.out.println("\nTHE VALUES OF NUMBERS INITIALLY:-\t" + num1 +"\t" +num2);

        //changing the values of the numbers
        ob1.chngval(num1,num2);

        System.out.println("\nTHE VALUES OF NUMBERS AFTER PASSING TO A FUNCTION:-\t" + num1 +"\t" +num2);

        ref_val ob2 = new ref_val(40,60);

        System.out.println("\nTHE VALUES OF OBJECT INITIALLY:-\t" + ob2.a +"\t" +ob2.b);

        //changing the values of the object
        ob1.chngval(ob2);

        /* since ob2 is a reference to a memory & java passes objects via reference
            i.e at the function another reference to the same memory location is created
           & changes made to that reference are changes made to memory.
           as soon as method/function gets over the reference present there is no more.
           but still i have a reference in main function which points to that memory
           & can access the changed values at that memory */

        System.out.println("\nTHE VALUES OF OBJECT AFTER PASSING TO A FUNCTION:-\t" + ob2.a +"\t" +ob2.b);


    }

}
