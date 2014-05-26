//PROGRAM TO SHOW HOW A SUPERCLASS VARIABLE ACCESSES A SUBCLASS VARIABLE


class A
{
    int a1;
    int a2;

    private int a3;


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

    void show()
    {
        System.out.println("\n\nTHE MEMBERS OF A ARE:-\t" + a1 +" " + a2 + " " +a3);
    }

    void set(int a,int b)
    {

    }

}


class B extends A
{

    int b1;
    int b2;


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


    void show()
    {
        System.out.println("\n\nTHE MEMBERS OF B ARE:-\t" + b1 +" " + b2);
             
    }

    void set(int a,int b)
    {
        b1 = a;
        b2 = b;
    }

}



class super_ref_sub
{
    public static void main(String args[])
    {
        B nb = new B();

        //members of object B
        nb.show();

        A na = new A(100,200);

        //members of object A
        na.show();


/************* IMPORTANT *****************/

/*  We can reference an object of subclass using a superclass
    ofcourse

    memory occupied = mem occupied by members of B + those of A


    here if class A's object references it then it shares that part of memory which has
    it's members.

    thus any changes made by either of the objects will be common for both references
    the following code proves it 
*/

///////////////VERY VERY IMPORTANT////////////
/*
    see, super class can refer to a sub class memory location
    now,u can access the methods of sub-class using super class ref.varible
    which override some function in class A


    e.g

    class A has a function

    void set(int a,int b)
    {
    ....
    ....
    }

    & class B also has
    void set(int a,int b)
    {
    ....
    ....
    }

    then reference varible of class A can call "set" function
    however if the "set" function isn'y provided in super class then
    u can't call "set" function of class B

    this is somewhat similar to virtual functions of c++ & in java it applies for varibles also


    */


    na = nb; //here na refers to a memory of object B
    /*
        if nb has overridden some varible or method of class A then that
        method or varible of object nb can be accessed by ref.varible of super-class
    */
    na.show(); //it calls the show function of class B

    /* if show method would not had been present in class A then above statement would have given errors
      as polymorphism would not have occured */

    int x = na.a1;  //here na refers to the varible of class A

    //it's getting messy yaar

///////////// SAAR YEH HAI KI //////////////

/*  the thing which matters is the type of memory location(object type) being referred by super-class refernce variable
    not the type of reference varible

*/



/*
    as the private members of Class A are not derived & (however memory is allocated for them & they can be used)
    u can't access them using the object of class A for the following case

    e.g na = nb;
        int x = na.a3; //a3 is private & isn't present in this shared memory

    but
    na = new A();
    na.a3;  is OK (a3 is private)


*/


    }

}
