package Util;

public class ScoreManager {

    private int score = 0;

    public ScoreManager(){
        this.score = score;
    }

    public void addScore(int n){
        int newScore = n + score;
        score = newScore;
    }

    public int getScore(){
        return score;
    }

    public void resetScore(){
        score = 0;
    }

}