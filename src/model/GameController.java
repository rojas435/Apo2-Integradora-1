package model;
import java.util.Random;

public class GameController {


    public void initBoard(){

    }

    public void inGame(int option){
        switch(option){
            case 1:

                break;

            case 2:

                break;

            default:
                System.out.println("Opcion invalida, intenta denuevo");
            break;        
        }
    }

    public void calculateScore(double time){
        double score =0;
        score = (600 - time)/6;
    }
}
