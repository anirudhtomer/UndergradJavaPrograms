//PROGRAM TO IMPLEMENT continue-goto COMMAND

class continue_goto
{
    public static void main(String args[])
    {

        int num[] = {1,2,3,4,5,6,7,8};

        int sum=0,i=4,j=4,k=4;

     outer: for(i=0;i<10;i++)
        {
            System.out.println();

            for(j=0;j<5;j++)
            {
                if(j>2)
                    continue outer;
                System.out.print(j + "\t");

            }


        }


    }
}
