//PROGRAM TO READ A DATA FROM A FILE

import java.io.*;

class read_line
{
    public static void main(String args[])
    {
        FileInputStream fin;   //fin is an object reference of class type FileInputStream   
        //file input stream to read from a source
        String str;


        try
        {
            System.out.print("\nENTER FILE NAME WITH EXTENSION:-\t");

            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            
            str = bfr.readLine();

            fin = new FileInputStream(str); //extension is must

            int i;

            while(true)
            {

                try
                {
                    i = fin.read();  //this is the overridden function

                    //this function returns -1 when eof file occurs else returns the ascii value in integer

                    if(i==-1)
                       break;

                    System.out.print((char)i);

                }
                catch(IOException e)
                {
                    System.out.println("ERROR OCCURED WHILE READING THE FILE");
                }
            }
			
			fin.close();
        }
        catch(Exception e)
        {
            System.out.println("FILE IS NOT AVAILABLE");
        }
    }
}



