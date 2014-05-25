/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import static cardgametrackercs319.Round.RoundType.*;

/**
 * This class represents the BlackJack card game tracking
 * @see Round
 * @author GroupA Spring 2014
 */

public class BlackJackGame extends CardGame {

    public BlackJackGame( int numOfRounds) {
        super(numOfRounds);
        for ( int i = 0; i < rounds.length; i++) {
            rounds[i] = new Round( "BlackJack-" + (i + 1), BLACKJACK);
        }
    }

    @Override
    public boolean checkGameInvariants( Round r) {
        int[] roundScores = r.getScores();
        return ( roundScores[0] >= -359 && roundScores[0] <= 21 && roundScores[1] >= -359 &&
                 roundScores[1] <= 21 && roundScores[2] >= -359 && roundScores[2] <= 21 &&
                 roundScores[3] >= -359 && roundScores[3] <= 21 );
    }
    
}
