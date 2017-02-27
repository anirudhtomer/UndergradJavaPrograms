/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cow_bull;

import java.util.ArrayList;

/**
 *
 * @author anirudh
 */
public class Cow {
    private int cowNumber;
    private boolean sureCow;
    private boolean [] probablePositions;
    
    static boolean[] notBullPosition = new boolean[4];
    
    static{
        notBullPosition[0] = true;
        notBullPosition[1] = true;
        notBullPosition[2] = true;
        notBullPosition[3] = true;
    }
    
    public Cow(int cowNumber, boolean sureCow) {
        this.cowNumber = cowNumber;
        this.sureCow = sureCow;
        
        this.probablePositions = new boolean[4];
        
        this.probablePositions[0] = notBullPosition[0];
        this.probablePositions[1] = notBullPosition[1];
        this.probablePositions[2] = notBullPosition[2];
        this.probablePositions[3] = notBullPosition[3];        
    }

    public boolean isSureCow() {
        return sureCow;
    }

    public void setSureCow(boolean sureCow) {
        this.sureCow = sureCow;
    }

    public int getCownumber() {
        return cowNumber;
    }

    public void setCownumber(int cownumber) {
        this.cowNumber = cownumber;
    }

    public int[] getProbablePositions() {
        int [] position = new int[4];
        int k=0;
        
        for(int i=0;i<4;i++){
            if(this.probablePositions[0] == true){
                position[k++] = i;
            }
        }    
        return position;
    }    
    
    public void setNotProbablePosition(int position){
        probablePositions[position] = false;
    }
}
