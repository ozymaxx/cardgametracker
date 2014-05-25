/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

/**
 *  This class represent a user with id, name and score
 * 
 * @author Group A Spring 2014
 */

public class User {
    private String id, name;
    private int score;
    
    public User( String id, String name) {
        this.id = id;
        this.name = name;
        score = 0;
    }
    
    public String getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score; 
    }
    
    public void updateScore( int amount) {
        score += amount;
    }
    
    public void setScore( int score) {
        this.score = score;
    }
    
    public void setName( String name) {
        this.name = name;
    }
}