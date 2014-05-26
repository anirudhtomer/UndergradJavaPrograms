// use of constructors & methods in enumerations

// as enumerations have static methods they don't need to be instantiated

enum religion
{
    hindu(1,"INDIA"),islam(13,"PAK"),sikh(90,"PUNJAB"),christ,jew(-56,"ISRAEL") ;  //various objects of enum are declared

    private int count;
    String country;

    religion(int p,String str) //objects like hindu,islam activate it as a parameter is passed to it
    {
        count = p;
        country = str;
    }

    religion() //object christ activates it
    {
        count = -1;
        country = "WORLD";
    }

    int getcount()
    {
        return count; //returns count related to a particular object
    }

    String getcountry()
    {
        return country; //returns country related to an object
    }
}

class enum_more
{
    public static void main(String args[])
    {
        for(religion r: religion.values()) //for each loop...the function returns an array thus it's used as a source
        {
            System.out.println("\n" + r + "\tcount:-  " + r.getcount() + "\tcountry:-  " + r.getcountry());
        }

        /* every object of enum is given an "ordinal value":: starts from "0" for the first element

        & then increments for every next object

        the function which returns the ordinal value is

        final int ordinal();

        */

        System.out.println("\n\nTHE ORDINAL VALUES FOR VARIOUS ENUM objects ARE:-\n\n");

        for(religion r:religion.values())
        {
            System.out.println("\n" + r + "\tordinal:-  " + r.ordinal());
        }

        //u can compare two objects also

        religion r1 = religion.hindu;
        religion r2 = religion.hindu;
        religion r3 = religion.islam;
        
        if(r1==r2)
        {
            System.out.println("\n\nOBJECTS ARE SAME");
        }
        else
        {
            System.out.println("\n\nOBJECTS ARE DIFFERENT");
        }

        if(r1==r3)
        {
            System.out.println("\n\nOBJECTS ARE SAME");
        }
        else
        {
            System.out.println("\n\nOBJECTS ARE DIFFERENT");
        }

    }                                              
}
