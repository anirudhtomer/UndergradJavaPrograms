//PROGARAM TO IMPLEMENT string operations in java


class usestr
{
    String str1,str2;


    usestr(String s1,String s2)
    {
        str1 = s1;    
        str2 = s2;
    }

    void showstr()
    {
        System.out.println("\n\nTHE FIRST STRING IS:-\t" + str1);
        System.out.println("\n\nTHE SECOND STRING IS:-\t" + str2);
    }

    void showlen()
    {
        System.out.println("\n\nTHE LENGTH OF FIRST STRING IS:-\t" + str1.length());
        System.out.println("\n\nTHE LENGTH OF SECOND STRING IS:-\t" + str2.length());
    }

    void equality()
    {
        if(str1.equals(str2))
            System.out.println("\n\nTHE STRINGS ARE EQUAL");
        else
            System.out.println("\n\nTHE STRINGS AREN'T EQUAL");

    }

    void concatty()
    {
        str1 = str1 + str2 + "concatination";
        System.out.println("\n\nTHE CONCATINATED STRING IS:-\t" + str1);
    }

    void char_index(int i)
    {
        System.out.println("THE CHARACTER AT INDEX " + i + " in string \" " + str2 + " \" is :-\t" + str2.charAt(i));
    }
}


class string_op
{
    public static void main(String args[])
    {
        usestr u1 = new usestr("iam anirudh\t","hello");
        usestr u2 = new usestr("anirudh","anirudh");

        
        u1.showstr();
        u1.showlen();
        u1.equality();

        u2.equality();
        u1.concatty();

        //character at index 0 is h
        u1.char_index(0);


        //implement array of string

        System.out.println("\n\nIMPLEMENTATION OF ARRAY OF STRINGS\n");

        String str[] = new String[4];

        str[0] = "anirudh";
        str[1] = "divya";
        str[2] = "munesh";
        str[3] = "yeshpal";

        /*it is strange but to find length of a string we call "stringname.length()"
          but to find the length of string array we use "stringarrayname.length" */


      /* the following code in quotes calculates the length of the integer array



        int intarr[] = {1,2,3,4};

        int p = intarr.length;

      */


        System.out.println("\nTHE SIZE OF STRING ARRAY IS:-\t" + str.length +"\n");

        int i = 0;
        for(String x:str) //using for-each loop
        {
                
            System.out.println("\n str[" + (i++) + "] :\t" + x);
        }
    }
}
