/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import static cardgametrackercs319.Round.RoundType.*;

/**
 * This class represents the MauMau card game tracking
 * @see Round
 * @author GroupA Spring 2014
 */

public class MauMauGame extends CardGame {

    public MauMauGame( int numOfRounds) {
        super( numOfRounds);
        for ( int i = 0; i < rounds.length; i++) {
            rounds[i] = new Round( "MauMau-" + (i + 1), MAUMAU);
        }
    }

    @Override
    public boolean checkGameInvariants( Round r) {
        int[] roundScores = r.getScores();
        return ( roundScores[0] >= 0 && roundScores[1] >= 0 && roundScores[2] >= 0 && roundScores[3] >= 0 &&
                 roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] <= 364);
    }
    
}
