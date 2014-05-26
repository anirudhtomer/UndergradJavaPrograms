//USE OF "final" to prevent inheritance


//a class declared as "final class name" can be inherited
// a function declared as final can't be overridden but can be inherited

/*****IMPORTANT***********/
/* "final" & "abstract" can't occur together because "abstract" means it has to be inhrited & should be overridden
   but "final" stops inheritance.......thus providing "final" & "abstract" together would have no meaning
*/


final class A
{
    int x;

    //abstract void area(); //produces error as final class can't be inherited & thus this function won't get an overridden definition


}

/*        this code produces error as no class can inherit "final" class
class B extends A
{


}*/

class C
{

    final void finale() //can't be overridden but can be inherited
    {
        System.out.println("\nHI IAM ANIRUDH");
    }

    final void hell() //can't be overridden but can be inherited
    {
        System.out.println("\nGO TO HELL");
        
    }
}

class D extends C
{
    int p;

    /* as this function tries to override a "final" function "void hell()" of super-class it produces errors
    void hell()
    {

    }
    */
}

class final_inherit
{
    public static void main(String args[])
    {
        D nd = new D();

        nd.finale();
        nd.hell();

    }
}
