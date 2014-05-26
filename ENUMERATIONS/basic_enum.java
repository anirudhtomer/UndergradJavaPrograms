// program to the basic use of "enumerations" in java

// enumerations are "classes" but no instance is created for them

enum state
{
    mp,kerala,punjab,up,assam
}

enum religion
{
    hindu,islam,sikh,christ,jew
}

class basic_enum
{
    public static void main(String args[])
    {
        state s;  //reference is delared however instance is not created as they behave like inbuilt types 

        s = state.mp;  //mp is a member of "enum class" state

        // if(s==1) //produces error as enum & int are incomparable types
        
        System.out.println("\nTHE ENUMERATION GIVEN TO s is:-\t" + s);

        s = state.punjab;

        switch(s)
        {
            case mp: System.out.println("HI IAM MP");
                     break;   
     
            case up: System.out.println("HI IAM UP");
                     break;

            case kerala: System.out.println("HI IAM KERALA");
                         break;

            case punjab: System.out.println("HI IAM PUNJAB");
                        break;

            case assam: System.out.println("HI IAM ASSAM");

        }

        /* ENUMEARTION IS A CLASS & HAS GOT INBUILT FUNCTIONS

            public static enum[] values()  //it returns all the objects of enum in an array
            public static enum valueOf(String str)

        */


//use of function values()

        for(religion r: religion.values()) //for each loop...the function returns an array thus it's used as a source
        {
            System.out.println("\n" + r);
        }
//use of function valueOf()

        System.out.println("\nTHE VALUE OF jew is ::\t" + religion.valueOf("jew"));

    }                                              
}
