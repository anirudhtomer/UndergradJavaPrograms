//PROGRAM TO IMPLEMENT classes IN java 

//DESTRUCTORS TO FREE MEMORY ARE NOT REQUIRED IN JAVA as it works on principle of GARBAGE COLLECTION
//don't use float instead of double as it shows error while passing values to constructor
// every primitive type of varible is to be initialezed before using it.  ( or be ready to get error)

class vol
{
    double height;
    double width;
    double length;

/*
 here i could have used parameters name different like
 "vol(double h,double w,double l)" but to know the proper use of the "this"
  pointer i had to use the same names in the function.

  here if i wouldn't had used "this" then "local variable height" will give value to
  itself & the original object.variable value will remain to be zero(java initialize every variable to zero)
   
  */
    
    vol(double height,double width,double length)
    {
        this.height = height;
        this.width  = width;
        this.length = length;
    }


    double volume()
    {
        return height*width*length;
    }

    void showval()
    {
        System.out.println("\n\nTHE HEIGHT = " + height);
        System.out.println("\nTHE WIDTH = " + width);
        System.out.println("\nTHE LENGTH = " + length);
    }

    void setval(double h,double w,double l)
    {
        height = h;
        width = w;
        length = l;
    }



}


class object_concept
{
    public static void main(String args[])
    {

        // OBJECTS ARE ALWAYS NEEDED TO BE INITIALIZED USING "new"
        //memory is freed automatically by java

        /* in java "vol box" tells that a reference to object of class "vol" is created
           but a memory space isn't yet allocated*/


        vol box = new vol(12.3,1,2.45);
        vol cox = box;

        //cox refers to memory allocated for box

        System.out.println("\n\nTHE VALUES FOR OBJECT BOX ARE:-");
        box.showval();

        System.out.println("\n\nTHE VALUES FOR OBJECT COX ARE:-");
        cox.showval();
        

        /* as cox refers to the memeory allocated for box thus any changes made at
         memory allocated for "reference box" will change values at cox */

        box.setval(10,20,30);

        System.out.println("\nTHE VALUES OF BOX & COX AFTER CHANGING THE VALUES OF BOX ONLY:::");

        System.out.println("\n\nTHE VALUES FOR OBJECT BOX ARE:-");
        box.showval();

        System.out.println("\n\nTHE VALUES FOR OBJECT COX ARE:-");
        cox.showval();

        /* in java if any reference is allocated new memory then we need not to think
           about memory leakage as it calls destructor or delete automatically */

        /* here i gave new memory to "box" but "cox" still refers to prevoius memeory
           thus java won't delete that memory till "cox" is referring to it.*/

        box = new vol(11,12,13);

        System.out.println("\nTHE VALUES OF BOX & COX AFTER ALLOCATING NEW MEMORY TO BOX ONLY:::");

        System.out.println("\n\nTHE VALUES FOR OBJECT BOX ARE:-");
        box.showval();

        System.out.println("\n\nTHE VALUES FOR OBJECT COX ARE:-");
        cox.showval();


        System.out.println("\n\nTHE VOLUME OF OBJECT BOX IS:-\t" + box.volume());


    }
}
