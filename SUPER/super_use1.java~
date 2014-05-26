//PROGRAM TO SHOW THE USE OF KEYWORD "super"

class A
{
    int a1;
    int a2;

    private int a3;
    String str = "IAM STRING OF A";


    A()
    {
        a1 = 1;
        a2 = 2;
        a3 = 10;
    }

    A(int a,int b)
    {
        a1 = a;
        a2 = b;
    }

    void showa()
    {
        System.out.println("\n\nTHE MEMBERS OF A ARE:-\t" + a1 +" " + a2);

    }

}


class B extends A
{

    int b1;
    int b2;

    String str = "IAM STRING OF B";
    

    B()
    {
        b1 = 11;
        b2 = 12;
    }

    B(int a,int b)
    {
        b1 = a;
        b2 = b;
    }


    void showb()
    {
        System.out.println("\n\nTHE MEMBERS OF B ARE:-\t" + b1 +" " + b2);

    }

    void printstr()
    {
        /* as "str" variable of class A gets overridden by "str" varible of class A
           can be accessed by using keyword "super"  (quite similar to " :: " of c++"
        */

        System.out.println("THE STRING OF B IS :-\t" + str);
        System.out.println("THE STRING OF A IS :-\t" + super.str);

    }


}



class super_use1
{
    public static void main(String args[])
    {
        B nb = new B();

        nb.printstr();

        /*
           the other way to access the "str" of class A is sharing memory with object of class B
           & then accessing "str" by reference "na"  */ 

        A na = nb;

        System.out.println("THE STRING OF A IS :-\t" + (na.str = "ani") );


    }

}
