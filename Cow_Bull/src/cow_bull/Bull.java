/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cow_bull;

/**
 *
 * @author anirudh
 */
public class Bull {
    
    private int bullpostion;
    private int bullnumber;

    public Bull(int bullnumber, int bullpostion) {
        this.bullpostion = bullpostion;
        this.bullnumber = bullnumber;
    }
    
    public int getBullnumber() {
        return bullnumber;
    }

    public void setBullnumber(int bullnumber) {
        this.bullnumber = bullnumber;
    }

    public int getBullpostion() {
        return bullpostion;
    }

    public void setBullpostion(int bullpostion) {
        this.bullpostion = bullpostion;
    }    
}
        
