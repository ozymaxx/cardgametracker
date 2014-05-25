/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import static cardgametrackercs319.Round.RoundType.*;

/**
 * This class represents the Batak card game tracking
 * @see Round
 * @author GroupA Spring 2014
 */

public class BatakGame extends CardGame {
    
    private final int MAX_OFFSET = 3;
    private final int MAX_SCORE = 130;
    private final int SCORE_PER_ROUND = 10;

    public BatakGame( int numOfRounds) {
        super( numOfRounds);
        for ( int i = 0; i < rounds.length; i++) {
            rounds[i] = new Round( "Batak-" + (i + 1), BATAK);
        }
    }

    @Override
    public boolean checkGameInvariants( Round r) {
        int[] roundScores = r.getScores();
        int positiveSum = 0;
        
        for ( int i = 0; i < roundScores.length; i++) {
            if ( Math.abs( roundScores[i]) > MAX_SCORE && roundScores[i] % SCORE_PER_ROUND > MAX_OFFSET || roundScores[i] < -130) {
                return false;
            }
            
            if ( roundScores[i] > 0) {
                positiveSum += roundScores[i];
            }
        }
        
        return ( positiveSum <= MAX_SCORE);
    }
    
}
