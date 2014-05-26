//PROGARAM TO USE "command line arguments"

class cmd_line
{
    public static void main(String args[])
    {

        /*

        if command is "java filename otherarguments"
          then "java" & "filename" won't be a part of array "args[]"
        "otherargumnets" seperated by space will be a part of "args[]"

        */


        System.out.println("THE ARGUMENTS PASSED TO \"main\" are:-\n");
        
        for(String temp:args)
        {
            System.out.println(temp + "\n");

        }

    }
}
