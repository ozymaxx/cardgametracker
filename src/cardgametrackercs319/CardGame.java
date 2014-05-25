/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

/**
 * This class represents an abstract class for KingGame,
 * BlackJackGame, MaumauGame, BatakGame
 * @see BlackJackGame
 * @see BatakGame
 * @see MaumauGame
 * @see KingGame
 * @see Round
 * @author GroupA Spring 2014
 */

public abstract class CardGame {
    Round[] rounds;
    int past;
    
    public CardGame( int numOfRounds) {
        rounds = new Round[numOfRounds];
        past = 0;
    }
    
    public boolean hasRounds() {
        return past < rounds.length;
    }
    
    public String getJSON( int x) {
        String result = "{\"game"+x+"\":[";
        for ( int i = 0; i < rounds.length; i++) {
            result += rounds[i].getJSON();
            if ( i < rounds.length - 1) {
                result += ",";
            }
        }
        result += "]}";
        
        return result;
    }
    
    public Round getCurrentRound() {
        return rounds[past];
    }
    
    public abstract boolean checkGameInvariants( Round r);
    
    public boolean insertScore( int s1, int s2, int s3, int s4) {
        rounds[past].setScores( s1, s2, s3, s4);
        
        if ( checkGameInvariants( rounds[past]) ) {
            if ( rounds.length > past) {
                past++;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
