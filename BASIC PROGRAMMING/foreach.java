//PROGRAM TO IMPLEMENT for-each LOOP

class foreach
{
    public static void main(String args[])
    {

        int num[] = {1,2,3,4,5,6,7,8};
        int sum=0;
		String uninit,initnull = null;
		
        //you can't print uinitialized variables in java's jdk6 (like uninit)  but can print "initnull"
            
        for(int x:num) //never ever declare x outside for loop
        {
            sum+=x;
        }

        System.out.println("\n\nTHE SUM IS:-\t" + sum);
		
		System.out.println("\n\ninitnull = " + initnull + true);  //can print keyword like "true/false/null" directly
    }
}
