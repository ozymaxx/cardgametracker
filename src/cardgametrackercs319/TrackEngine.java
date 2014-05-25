/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import java.util.Random;

/**
 * This class keep the information of all games
 * @see CardGame
 * @see User
 * @author Group A Spring 2014
 */

public class TrackEngine {
    
    private final int NUM_OF_ROUNDS = 11;
    private final int NUM_OF_USERS = 4;
    
    private int curPlayed;
    private int cur;
    private CardGame[] games;
    private User[] players;
    private boolean[] played;
    
    public TrackEngine( int numOfGames, boolean[] played, User[] users) {
        this.played = new boolean[4];
        for ( int y = 0; y < played.length; y++) {
            this.played[y] = played[y];
        }
        players = users;
        curPlayed = 0;
        cur = 0;
        games = new CardGame[numOfGames];
        Random generator = new Random();
        int gameNum = generator.nextInt( 4);
        for ( int x = 0; x < games.length; x++) {
            while ( !( this.played[gameNum] ) ) {
                gameNum = generator.nextInt( 4);
            }
            if ( this.played[gameNum]) {
                if ( gameNum == 0) {
                    games[x] = new BatakGame( NUM_OF_ROUNDS);
                }
                else if ( gameNum == 1) {
                    games[x] = new MauMauGame( NUM_OF_ROUNDS);
                }
                else if ( gameNum == 2) {
                    games[x] = new KingGame( NUM_OF_ROUNDS);
                }
                else {
                    games[x] = new BlackJackGame( NUM_OF_ROUNDS);
                }
            }
            gameNum = generator.nextInt( 4);
        }
    }
    
    public String getUserName( int index) {
        return players[index].getName();
    }
    
    public int getUserScore( int index) {
        return players[index].getScore();
    }
    
    public boolean hasGames() {
        return curPlayed < games.length;
    }
    
    public boolean updateScore( int s1, int s2, int s3, int s4) {
        if ( hasGames() ) {
            if ( games[curPlayed].hasRounds() ) {
                players[0].updateScore( s1);
                players[1].updateScore( s2);
                players[2].updateScore( s3);
                players[3].updateScore( s4);
                boolean result = games[curPlayed].insertScore( s1, s2, s3, s4);
                
                if ( !( games[curPlayed].hasRounds() ) ) {
                    curPlayed++;
                }
                
                return result;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    public String getCurrentRoundName() {
        return games[curPlayed].getCurrentRound().getName();
    }
    
    public String getJSON() {
        String result = "{\"info\":[";
        for ( int i = 0; i < games.length; i++) {
            result += games[i].getJSON(i);
            if ( i < games.length - 1) {
                result += ",";
            }
        }
        result += "],\"p1\":\""+players[0].getID()+"\",\"p2\":\""+players[1].getID()+"\",\"p3\":\""+players[2].getID()+"\",\"p4\":\""+players[3].getID()+"\"}";
        
        return result;
    }
}
