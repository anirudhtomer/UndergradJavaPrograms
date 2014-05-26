// JRTS-(java run time syatem)

//PROGRAM TO SHOW "use of static,final,description of main" in java

// MOST PROGRAMMERS DO NOT USE STATIC & its really a powerful keyword
// good uses of "static" & "final (const in c & c++)" are rare

/* static are class members & memory is alloted to them before any objects are made
   as soon as the class is loaded the static members are run */

/* "this" pointer is not passed to static objects as they not object members
    they are common for all objects and thus there is no need to specify "this"
    pointer to differentiate between objects */

// static members can be called by "dot operator"
// static methods can use only static members of the class
// since main is a static method u can't call a nonstatic method from it

//MUST...MUST....MUST READ EVERYTHING



class ref_val
{
    // even without using constructors we can give values to variables in class..it also works as a constructor
    
    int a=5,b=10; // even without using constructors we can give values to variables in class..it also works as a constructor

    static int alpha = 10;
    final int beta = 20;


    ref_val(int a,int b)
    {
        System.out.println("\nHI IAM IN PARAMETRIZED CONSTRUCTOR");

        this.a = a;
        this.b = b;
    }

    ref_val()
    {
        System.out.println("\nHI IAM IN DEFAULT CONSTRUCTOR");

        //beta =9;  //produces error that value of a final variable can't be changed
    }


    ref_val getnew(int p,int q)
    {
        ref_val obj = new ref_val(p,q);

        return obj;
    }

    ref_val getnew()
    {
        this.showstatic(this,this.a); // we are passing non static members as parameters but "int" goes by value & static method can use "refernece of the memory "as it's a part of that function 
        this.alpha = 999;

        /* see its a bit confusing but...."this.alpha" or "this.showstatic()" in a non static method is OK
           there is no relation b/w "this" & "static variables" as such
            but a relation b/w "this" & static" variables exist when "this" is used inside a static method */ 

        ref_val obj = new ref_val();

        return obj;
    }

    void showval()
    {
        System.out.println("\nTHE VALUE OF \"a\" is:-\t" + a);
        System.out.println("\nTHE VALUE OF \"b\" is:-\t" + b);
        System.out.println("\nTHE VALUE OF CONSTANT \"beta\"is:-\t" + beta);
    }

    static void showstatic(ref_val r,int p) 
        {
        
        //following two statement gives same error that a non-static member can't be referenced from a static context

        //System.out.println("\nTHE VALUE OF \"a\" is:-\t" + a);
        //this.alpha = 10; //alpha is static but i think that "this.alpha" makes it an object member

        System.out.println("\nTHE VALUE OF \"alpha(static var)\" is:-\t" + alpha);
    }


/////////////////IMPORTANT NOTE///////////////////

/* we can even have blocks to be static. If the following statements are not written in blocks
then error occurs :: "identifier expected"........i.e we have to specify
description of every block either... static or non-static (examples of both are below)
even when we write anything in "main" then "main" itself descripts everything:: "public static void main(String args[])" 
*/


////////////HOW STATIC BLOCKS (for classes not containig main's definition) ARE EXECUTED //////////////

/*  don't confuse blocks with methods

1.  ALL STATIC BLOCKS ARE EXECUTED ONLY ONCE IN THE PROGARM...
    THAT TOO WHEN "FOR THE FIRST TIME AN OBJECT OF SUCH CLASSES IS CREATED

2.  ALL NON STATIC BLOCKS ARE EXECUTED EVERYTIME A NEW OBJECT IS CREATED.
3.  IF A NON STATIC BLOCK IS TYPED BEFORE A STATIC BLOCK THEN IT WILL EXECUTE
    (A).THE STATIC BLOCK IF THE CONTROL TO EXECUTE THE STATIC BLOCKS IS PRESENT
        i.e this is the very first object of this class in the program.

4.  it is amazing to know that constructor for object is invoked at last i.e after execution of blocks
    the following thing makes u understand it in a better way



the very first statement in main is "ref_val ob1 = new ref_val(100,200);"
foloowing things happen in it:-

1. as soon as "ref_val ob4 = new ref_val;" is executed a memory of type "ref_val" is given
   to is allocated to "ob4"
2. as this is the very first object of this class in the program
   all static blocks will get executed now only...however nonstatic blocks are
   executed everytime a new block is created
3. so "HI THIS IS JUST A TRAILER OF STATICITY" is printed on screen.
   the next block typed after it is also a static block 
5. as soon as we enter into that static block it's execution starts
        
6. the first statement in it is "ref_val ob4 = new ref_val();"
   this will push everything onto stack & the control for executing the
   the things of "ob4" is done.

7. the NON STATIC BLOCK IS EXECUTED FOR IT (for object "ob4")..."HI IAM IN NON STATIC BLOCK" is printed
   the control to execute last static block is not here & was pushed on the stack

8. default constructor is invoked & control is sent back by popping the stack at the statement after
   the statement "ref_val ob4 = new ref_val();"

9.  now we have got the control to execute the static blocks
    "HI IAM IN STATIC BLOCK" IS EXECUTED.

10. the last static block is now executed & "HI THIS IS END OF STATICITY"
    is printed.

11. the statement "HI IAM IN NON STATIC BLOCK" (for object "ob1")is executed now.

12. parametrized constructor for object "ob1 (present in main)" is executed

13. control is sent back to main.

14. at this instant all static blocks are executed & if further any objects
    are created for this class then non static blocks will get executed again
    & then their respective constructors will be invoked.
	
15. u can invoke all static block initially without creating an instance of class
by
	
classname.stacticmethod();	//here iam calling method by class name not by cretating an object & then calling by it
or by
classname.staticvariable = something...;
if these are the first statement then all static blocks get executed

 wasn't it a bit tough... it was */


    
    static
    {
        System.out.println("\nHI THIS IS JUST A TRAILER OF STATICITY");
    }

    static
    {
        ref_val ob4 = new ref_val();
        System.out.println("\nHI IAM IN STATIC BLOCK");
        //b = 14;   //this statement produces errors becuse u can't use non static members in a static block
		ob4.b = 17;  //this won't produce error as we can access non static memebers of a class in a static block using it's object.
    }

    {
        a=16;
        System.out.println("\nHI IAM IN NON STATIC BLOCK");
    }

    static
    {
        System.out.println("\nHI THIS IS END OF STATICITY");
    }
        
        

}

class static_final_main_descrip
{
    /*if we don't write static here ... no error would come & block won't execute
      because without static the java run time system would assume that it has to return
      back to OS after main is over......by writing it makes sure that this block is executed first
      u know every static block is executed first...if u don't write static JRTS will call main directly &
      as soon as main is over it returns back
    */

    /* THERE ARE TWO STATIC BLOCKS IN THIS CLASS ALONG WITH "main"
       One at beginning & one at end......now as soon as .class file is made
       the JRTS finds that two static blocks are present in it...so it executes them
       first...the static block at beginning is executed first & the
       static block at last is executed after it.....THE BLOCK WHICH IS NOT STATIC IS NOT EXECUTED
       however non-static blocks are executed in classes not containing "main's" definition
       or which are not intervened by JTRS */


    {
        System.out.println("HI THIS BLOCK WON'T GET EXECUTED");
    }


    static
    {
        System.out.println("\n\nIAM IN JAVA & HAVE JUST STARTED\n\n");
    }


    /***************** IMPORTANT NOTE *********************/

    /* "public" access specifier for main makes the main method to be accessible
       outside the program.........it is called by a "code for java run time system"
       which is outside this program */


    /* "static" is written for main because static methods exist even before the objects
        for that class are made.......static methods are part of class not of objects*/

//VERY IMPORTANT NOTE (PUBLIC ACCESS)

    /* make it "private static void main(String args[])"
       now the code for jun run time system won't be able to call main
       as it has "private access" &
        an error comes::"Main method is not public"

       So according to me system has to get an object of the class
       containing main & it should have another public method by which
       it will be able to call main.......& if that public method is not present
       then nobody will be able to break this encapsulation and call main.
       even if system gets a public method by which it calls the "private main method"
       there is no fucking use of that yaar. We want the main to be called by 
       "code for java time system" to run program.*/


//VERY IMPORTANT NOTE (STATIC KEYWORD)

    /* if we remove the static keyword & make it either

    "public void main(String args[])"    or
    "private void main(String args[])"

    then in both cases system needs objects of class containing main method
    to call main....as system won't to able to make such object thus there is no
    such question of a main method being present.

    so an error comes::"Exception in thread main java.lang.No such method error:main"

    So according to me if it becomes static then it does not need any object to
    call main (as static members are class members) & system works properly */


////////////////// main STARTS HERE //////////////////////

    public static void main(String args[])
    {

        ref_val ob1 = new ref_val(100,200);
        ref_val ob2;

        //ob2.showval(); //it shows the error that reference is not initialized

        ob2 = ob1.getnew();   //now reference variable has been given a memory space to work upon

        ob2.showval();
        ob2.showstatic(ob1,7);

        ref_val ob3 = new ref_val();

    }

   
    static
    {
        System.out.println("\n\nIAM IN JAVA & IAM LEAVING NOW (it should get printed at this place only)\n\n");
    } 

}
