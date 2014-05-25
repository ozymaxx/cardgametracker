/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import cardgametrackercs319.Round.RoundType;
import static cardgametrackercs319.Round.RoundType.*;
import java.util.Random;

/**
 * This class represents the King card game tracking
 * @see Round
 * @author GroupA Spring 2014
 */

public class KingGame extends CardGame {
    
    private final int MAX_NEGATIVE = 325;
    private final int MIN_NEGATIVE = -650;
    private final int NEGATIVE_TRICK_LOSE = 75;

    public KingGame( int numOfRounds) {
        super(numOfRounds);
        for ( int i = 0; i < rounds.length; i++) {
            String roundName = "King-";
            RoundType roundType;
            int temp = new Random().nextInt(8);
            if ( temp == 0) {
                roundType = NOHEARTS;
                roundName += "No Hearts";
            }
            else if ( temp == 1) {
                roundType = NOQUEENS;
                roundName += "No Queens";
            }
            else if ( temp == 2) {
                roundType = NOKINGSJACKS;
                roundName += "No Kings and Jacks";
            }
            else if ( temp == 3) {
                roundType = NOKINGHEARTS;
                roundName += "No King Hearts";
            }
            else if ( temp == 4) {
                roundType = NOLASTTWO;
                roundName += "No Last Two";
            }
            else if ( temp == 5) {
                roundType = NOTRICK;
                roundName += "No Trick";
            }
            else if ( temp == 6) {
                roundType = POSITIVE;
                roundName += "Positive";
            }
            else {
                roundType = NEGATIVE;
                roundName += "Negative";
            }
            roundName += (i + 1);

            rounds[i] = new Round( roundName, roundType);
        }
    }

    @Override
    public boolean checkGameInvariants( Round r) {
        int[] roundScores = r.getScores();
        if ( r.getRoundType() == NOHEARTS || r.getRoundType() == NOTRICK) {
            return ( roundScores[0] % 20 == 0 && roundScores[1] % 20 == 0 && roundScores[2] % 20 == 0 && roundScores[3] == 0 &&
                     roundScores[0] <= 0 && roundScores[1] <= 0 && roundScores[2] <= 0 && roundScores[3] <= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == -260);
        }
        else if ( r.getRoundType() == NOKINGSJACKS) {
            return ( roundScores[0] % 30 == 0 && roundScores[1] % 30 == 0 && roundScores[2] % 30 == 0 && roundScores[3] % 30 == 0 &&
                     roundScores[0] <= 0 && roundScores[1] <= 0 && roundScores[2] <= 0 && roundScores[3] <= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == -240);
        }
        else if ( r.getRoundType() == NOKINGHEARTS) {
            return ( roundScores[0] % 160 == 0 && roundScores[1] % 160 == 0 && roundScores[2] % 160 == 0 && roundScores[3] % 160 == 0 &&
                     roundScores[0] <= 0 && roundScores[1] <= 0 && roundScores[2] <= 0 && roundScores[3] <= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == -160);
        }
        else if ( r.getRoundType() == NOLASTTWO) {
            return ( roundScores[0] % 90 == 0 && roundScores[1] % 90 == 0 && roundScores[2] % 90 == 0 && roundScores[3] % 90 == 0 &&
                     roundScores[0] <= 0 && roundScores[1] <= 0 && roundScores[2] <= 0 && roundScores[3] <= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == 180);
        }
        else if ( r.getRoundType() == NOQUEENS) {
            return ( roundScores[0] % 50 == 0 && roundScores[1] % 50 == 0 && roundScores[2] % 50 == 0 && roundScores[3] % 50 == 0 &&
                     roundScores[0] <= 0 && roundScores[1] <= 0 && roundScores[2] <= 0 && roundScores[3] <= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == -200);
        }
        else if ( r.getRoundType() == POSITIVE) {
            return ( roundScores[0] % 25 == 0 && roundScores[1] % 25 == 0 && roundScores[2] % 25 == 0 && roundScores[3] % 25 == 0 &&
                     roundScores[0] >= 0 && roundScores[1] >= 0 && roundScores[2] >= 0 && roundScores[3] >= 0 &&
                     roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == 325);
        }
        else {
            boolean rightScores = true;
            for ( int i = 0; i < roundScores.length; i++) {
                boolean right = false;
                for ( int j = MAX_NEGATIVE; j >= MIN_NEGATIVE; j -= NEGATIVE_TRICK_LOSE ) {
                    if ( roundScores[i] == j) {
                        right = true;
                    }
                }
                rightScores = rightScores && right;
            }
            boolean rightSum = roundScores[0] + roundScores[1] + roundScores[2] + roundScores[3] == MAX_NEGATIVE;
            
            return rightScores && rightSum;
        }
    }
    
}
