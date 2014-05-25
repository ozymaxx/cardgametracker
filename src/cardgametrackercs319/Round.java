/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

/**
 *  This class represents a single round in any card game
 * 
 * @author GroupA Spring 2014
 */

public class Round {
    public enum RoundType {
        NOHEARTS, NOQUEENS, NOKINGSJACKS, NOKINGHEARTS, NOLASTTWO, NOTRICK, BATAK, BLACKJACK, MAUMAU, POSITIVE, NEGATIVE
    }
    
    private String name;
    private int[] scores;
    RoundType roundType;
    
    public Round( String name, RoundType type) {
        this.name = name;
        scores = new int[4];
        roundType = type;
    }
    
    public int[] getScores() {
        return scores;
    }
    
    public String getName() {
        return name;
    }
    
    public void setScores( int s1, int s2, int s3, int s4) {
        scores[0] = s1;
        scores[1] = s2;
        scores[2] = s3;
        scores[3] = s4;
    }
    
    public RoundType getRoundType() {
        return roundType;
    }
    
    public String getJSON() {
        return "{\""+name+"\":{\"s1\":"+scores[0]+", \"s2\":"+scores[1]+", \"s3\":"+scores[2]+", \"s4\":"+scores[3]+"}}";
    }
}
