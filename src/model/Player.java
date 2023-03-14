package model;
public class Player extends Node {

    public Player(int value) {
        super(value);
        
    }

    private char icon;
    private int score;
    private Slot currentPosition;
    

    public char getIcon() {return icon;}

    public void setIcon(char icon) {this.icon = icon;}

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

    public Slot getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Slot currentPosition) {
        this.currentPosition = currentPosition;
    }

    
   

    


    

}