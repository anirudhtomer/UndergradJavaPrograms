//PROGRAM TO SHOW HOW TO USE ABSTRACT CLASSES


//for abstract classes references can be created but memory can't be allocated
//methods can also be abstract & they are complusory to be overridden by sub-classes....abstract class can have "concrete methods (non abstract methods)" also


abstract class A
{
    double dim1,dim2;


    A()
    {
        dim1 = 1;
        dim2 = 1;
    }

    A(double a,double b)
    {
        dim1 = a;
        dim2 = b;
    }

    abstract void area(); //can't be called

    void concretefunc()
    {
        System.out.println("\n\nHI THIS IS A CONCRETE METHOD IN AN ABSTRACT CLASS...");
    }

}


class rect extends A
{

    rect(double a,double b)
    {
        super(a,b);
    }

    rect()
    {
        super();
    }

///////////important ///////////
/*
    if i don't provide void area in sub-class then error would be generated
    that overridden definition of the abstract function "void area" is not provided.
    hence all abstract functions of super class should be overridden.
    however other functions like "int area()" can be provided too but "void area()" is must
*/


    void area()  
    {
        System.out.println("\nTHE AREA OF THE RECTANGLE IS:-\t" + dim1*dim2);
    }



}

class abstract_class
{
    public static void main(String args[])
    {
        rect r = new rect(10.45,90.4);

        r.area();

        //A ref = new A(); //produce error as memory can't be allocated for abstract classes
        A ref = r;

        ref.area();
        ref.concretefunc();
        
    }

}

