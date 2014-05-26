//PLEASE REFER TO THE   "I/O & APPLETS" CHAPTER OF THE COMPLETE REFERNCE WHILE READING THESE PROGRAMS

//PROGRAM TO IMPLEMENT I/O OPERATIONS  ON CONSOLE IN JAVA

/* system always think about the ASCII values, now its up to u how u receive them  */


import java.io.*;

class basic_io_console
{
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {

            System.out.println("\nREADING FROM THE KEYBOARD IN CHARACTER FORM TILL U PRESS '0' ");

            char ch;

            do
            {
                ch = (char)br.read();  //reads them in the integer form by default
                System.out.println(ch);

            }while(ch!='0'); //or u can use while(ch!=48);


            System.out.println("\nREADING FROM THE KEYBOARD IN INTEGER FORM TILL U PRESS '0' ");

            int num;

            do
            {
                num = br.read();  //reads them in the integer form by default & returns the ascii value of the character
                System.out.print(num + "\t");

            }while(num!=48); //or u can use while(num!='0');
			
			//READING A STRING FROM THE KEYBD
			
			String str;
            String stry[];

            stry = new String[5];

            str = br.readLine();

            System.out.println("\n\n" + str +"\n\nENTER 5 MORE LINES\n\n");

            for(int i =0;i<5;i++)
            {
                stry[i] = br.readLine();
            }

            for(String s:stry)
            {
                System.out.println(s);
            }
		
	
        }

        catch(IOException e)
        {
            System.out.println(e);
        }
		
		
		PrintWriter pw = new PrintWriter(System.out,true);  //the argument true means that the output stream is flushed everytime a println statement is executed

        pw.println("HI THIS IS THE \" PrintWriter \"  way to print string. ");

    }
}

