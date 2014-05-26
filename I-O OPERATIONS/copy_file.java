//PROGRAM TO COPY ONE FILE TO ANOTHER

import java.io.*;

class copy_file
{
    public static void main(String args[])
    {
        FileInputStream fin;
        FileOutputStream fout;

        try
        {
            String fname[];

            fname = new String[2];

            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("\nENTER THE SOURCE FILE NAME WITH EXTENSION:-\t");
            fname[0] = bfr.readLine();

            System.out.print("\nENTER THE DESTINATION FILE NAME WITH EXTENSION:-\t");
            fname[1] = bfr.readLine();


            try
            {
                fin = new FileInputStream(fname[0]);
                fout = new FileOutputStream(fname[1]);

                try
                {
                    int ch;  //don't use "char ch;" here ...the loop may become infinite

                    while(true)
                    {
                        ch = fin.read();

                        if(ch==-1)
                            break;

                        fout.write(ch);
                    }
                }
                catch(IOException e)
                {
                   System.out.println("\nIO EXCEPTION WHILE COPYING");
                   return;
                }


            }
            catch(FileNotFoundException e)
            {
                System.out.println("FILE IS NOT FOUND SO MAKE NEW FILES");
                return;
            }

            fin.close();
            fout.close();
             
        }

        catch(IOException e)
        {
            System.out.println("IO EXCEPTION " + e +"\nDURING ENTRY OF NAMES");
            return;
        }

        System.out.println("\nFILE IS COPYED");
    }
}



