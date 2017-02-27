/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cow_bull;

/**
 *
 * @author anirudh
 */
public class Candidate {
    private int candidateNumber;
    private Cow cow;

    public Candidate(int candidateNumber, Cow cow) {
        this.candidateNumber = candidateNumber;
        this.cow = cow;
    }

    public int getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(int candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }    
}
