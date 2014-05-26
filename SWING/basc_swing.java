//PROGRAM TO SHOW WORKING OF SWING(basic)

import javax.swing.*;


class dalla 
{
    dalla()
    {
        JFrame j1 = new JFrame("HI THIS IS MY SWING APP");

        j1.setSize(500,500);

        j1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //EXIT_ON_CLOSE

        j1.add(new JLabel("HI IAM ANIRUDH"));

        j1.setVisible(true);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
        public void run()
        {
            new dalla();
        }
        });
    }
}

