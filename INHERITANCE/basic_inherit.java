//PROGRAM TO SHOW "basics of inheritance"

//the inherited class is called as "SUPER CLASS" & the inheriting class is called "SUB CLASS"
// private members ar not at all inherited but can be used using functions of super-class because memory is allocated for them during inheritance
//super class constructors are invoked first & sub class later


class A
{
    int a1,a2;

    static int a3;
    private String str;


    A()
    {
        System.out.println("\nDEFAULT CONSTRUCTOR OF A");
        a1 = 1;
        a2 = 2;
        a3 = 3;
        str = "private of A";
        
    }


    A(int a,int b,int c)
    {
        System.out.println("\nPARAMETRIZED CONSTRUCTOR OF A");

        a1 = a;
        a2 = b;
        a3 = c;
        str = "private of A";
    }


    static void showstatic()
    {

        System.out.println("\nTHE STATIC MEMBER OF CLASS A:-\t"  + a3);

    }

    /*

    "showall" & "showallA" do the same thing but as subclass B also has a
    "showall" method which overrides the "showall" method of class A ,
    i had to use a "showallA" so that inherited members of class A can be printed by using a call from
    objects of class B

    */


    void showall()//gets overridden by "showall" of sub-class
    {
        System.out.println("\nTHE NON STATIC MEMBERS OF CLASS A:-\t"  + a1 + "  " + a2 + " " + str);

    }

    void showall(int x) //this function gets overloaded not overridden
    {
        x = 20;
        System.out.println("\nTHE NON STATIC MEMBERS OF CLASS A:-\t"  + a1 + "  " + a2 + " " + str);

    }

    void showallA()
    {
        System.out.println("\nTHE NON STATIC MEMBERS OF CLASS A:-\t"  + a1 + "  " + a2 + " " + str);

    }


}



class B extends A     //the keyword extends show that "B inherits properties of A"
{

    int b1,b2;


    B()
    {
        System.out.println("\nDEFAULT CONSTRUCTOR OF B");
    
        b1 = 100;
        b2 = 200;
    }

    B(int a,int b)
    {
        System.out.println("\nPARAMETRIZED CONSTRUCTOR OF B");
    
        b1 = a;
        b2 = b;
    }


    void showall()
    {
        System.out.println("\nTHE NON STATIC MEMBERS OF CLASS B:-\t"  + b1 + "  " + b2);

    }

/*  This function shows errors for the access of member "str" of class A as
    it's private & can't be derived 

    void showallderiv()
    {
        System.out.println("\n\nTHE DERIVED CONTENTS ARE :-\t" + a1 +" " +a2 + " " + a3 + " " + str + "dervi");
    }

*/

}


class basic_inherit
{
    public static void main(String args[])
    {
        B nb = new B(5,6);

        /********IMPORTANT***********/

        /*
           the above statement calls the default constructorof class A & then parametrized constructor of class B
           static member of class A (a3) = 3;
        */

        nb.showstatic();

        A na = new A(10,20,30); //calls parametrized constructor of class A
                    //static member = 30;

        //it dosen't matter how many class inherit class A, the static member has only one instance of in the whole progarm
        // so every sub class have the same static member & any changes made to it will be common for all classes


        //properties of object "na"
        na.showall();
        na.showstatic();//it shows 30 because static member is already initialized by class A's object na

        //properties of object "nb"
        nb.showall(); //it overrides the showall method of class A

        //so to know the inherited members of class A 
        nb.showallA();

        /* however we can call the other showall of class A using object of class B directly as
           that has different function signature & thus gets overloaded not overridden */
        nb.showall(23);

        //String str1 = nb.str; //it shows error as str is not derived in B being a private member of A

        nb.showstatic(); //it shows 30 because static member is already initialized by class A's object na

    }
}
