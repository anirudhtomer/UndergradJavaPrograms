//PROGRAM TO SHOW THE USE OF KEYWORD "super" & how to use private members of super class which are not at all inherited

//super class object can refer to sub class object.....& objects are passed via reference

class C
{
    boolean c1 = true;
}

class A
{
    private int a1;
    private int a2;

    private String str = "IAM STRING OF A";
    private C x;

    A()
    {
        a1 = 1;
        a2 = 2;
        str = "HELLO DEFAULT A";
        x = new C();
        
    }

    A(int a,int b)
    {
        a1 = a;
        a2 = b;
        str = "HELLO PARAMETRIZED A";
        x = new C();
    }

    A(A obj)  //super class constructor collects the object of sub class type & gets the data required
    {
        a1 = obj.a1;
        a2 = obj.a2;
        str = "HELLO OBJECTED A";
        x = obj.x;
    }


    void showa()
    {
        System.out.println("\n\nTHE MEMBERS OF A ARE:-\t" + a1 +" " + a2 + " " + str + " "+x.c1);

    }

    String getstrA()
    {
        return str;
    }

    C getobjA()
    {
        return x;
    }

    void setA(int a,int b,String str,C v)
    {
        a1 = a;
        a2 = b;
        this.str = str;
        x = v;
    }



}


class B extends A
{

    int b1;

    /*

    while inheriting features of a super class the default constructor is always invoked
    but we can invoke any constructor of super class (even of a super class which has all private members)
    by using "super(arguments..." in the constructors of sub class

    & remember it should be the first statement in a constructor

    */




    B()
    {
        super(67,68);

        b1 = 11;

       // super(67,68);//wrong statement as this call should be the first statement in a constructor

        System.out.println("\nHELLO DEFAULT B");
    }

    B(int a)
    {
        b1 = a;
        System.out.println("\nHELLO PARAMETRIZED B");

    }

    B(B obb)
    {
        super(obb);  //passing the object of sub class to a super class constructor
        b1 = obb.b1;
        System.out.println("\nHELLO OBJECTED B");

    }

    void showb()
    {
        System.out.println("\nTHE MEMBER OF B IS:-\t" + b1);
    }
    
}



class super_use2
{
    public static void main(String args[])
    {
        B nb = new B();

        nb.showb();

/*
    private members are not inherited but memory is allocated for them. so to
    "print them or use them or change them" for calculations we can use functions of class A.
    however statement like "int x = nb.a1" won't work

    another way to change these private values is to return them from a function of
    super class & make appropriate changes & then put them back again.
    the sub-class object would be calling those derived functions, as shown in the
    following code:
*/

        nb.showa();
        String ptr = nb.getstrA();

        ptr = ptr + "anirudh";

        C nc = nb.getobjA();

        nc.c1 = false;

        nb.setA(100,200,ptr,nc);
        nb.showa();


        /////////////////// IMPORTANT //////////////////
/*

    the following code passes the object of "sub-class" type to constructor of "sub-class"
    the sub class passes it to super-class constructor by  "super(object)"  & later initializes itself with it.
the two important things to be noted are

1. while passing objects "pass by reference (common memory)" is chosen
2. the super class constructor collects the object of class B as the super class object can refer the sub-class object
    as some part of it's memory constitutes the "super class derived object"..thus the super class object can use it
    to initialize itself.

    following code show this thing
*/
    B nb2 = new B(nb);

    nb2.showb();
    nb2.showa();



    }

}
