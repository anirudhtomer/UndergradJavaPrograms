//PROGRAM TO IMPLEMENT break-goto COMMAND

class break_goto
{
    public static void main(String args[])
    {

        int num[] = {1,2,3,4,5,6,7,8};

        int sum=0,i=4,j=4,k=4;


 //     alpha: for(sum=10;sum>0;sum--)  
 //            break third;  //this statement produces error that "undefined symbol third"


        while(i>0)
 first: {
            while(j>0)
 second:    {
                while(k>-1)
 third:         {
                    k--;
                    if(k==2)
                        break first; //break alpha;  produces error "undefined symbol alpha
                        //so u can break inside nested loops only
                }
                j--;
            }
            i--;
     
        }


    }
}
