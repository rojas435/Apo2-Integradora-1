package model;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int sizeX;

    private int sizeY;

    private int snakeNum;

    private int laddersNum;

    private Node start;

    private Node end;

    private ArrayList<Integer> positionArrayS;

    private ArrayList<Integer> positionArrayL;

    public Board(int rows, int columnas, int snakes, int ladders) {
        this.sizeX = columnas;
        this.sizeY = rows;
        this.snakeNum = snakes;
        this.laddersNum = ladders;
        this.start = null;
        createSPosition(snakes*2,(columnas*rows), 0);
        createLPosition(ladders*2, (columnas*rows), 0);
        createBoard((columnas*rows), 0);
    }

    private void createBoard(int boardLimit, int boardNodeCounter) {
        boardNodeCounter+=1;
        if(boardNodeCounter<=boardLimit){
            if(SnakePosition(boardNodeCounter, 0)==true){
                Snakes snake = new Snakes(boardNodeCounter);
            } else if(LadderPosition(boardNodeCounter, 0)==true){
                Ladders ladder = new Ladders(boardNodeCounter);
            } else {
                Node node = new Node(boardNodeCounter);
                addNode(node);
            }
            createBoard(boardLimit, boardNodeCounter);
        }
        return;
    }

    private void addNode(Node node){
        if(start==null && end==null){
            start = node;
            end = node;
        } else{
            end.setNext(node);
            node.setPrevious(end);
            end = node;
        }
    }

    private boolean SnakePosition(int position, int counter){
        if(counter==positionArrayS.size()){
            return false;
        }
        if(position==positionArrayS.get(counter)){
            return true;
        }else {
            SnakePosition(position, counter+1);
        }
        return false;
    }
    private boolean LadderPosition(int position, int counter){
        if(counter==positionArrayL.size()){
            return false;
        }
        if(position==positionArrayL.get(counter)){
            return true;
        }else {
            SnakePosition(position, counter+1);
        }
        return false;
    }
    private void createSPosition(int snake, int positions, int counter){
        if(snake==counter){
            return;
        }
        Random rand = new Random();
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 && int_random!=positions-1){
            if(positionArrayS==null){
                positionArrayS.add(int_random);
            }else {
                boolean repeated=checkArrayValueS(int_random, 0);
                if(repeated==false){
                    positionArrayS.add(int_random);
                    createSPosition(snake, positions, counter+1);
                }else{
                    createSPosition(snake, positions, counter);
                }
            }
        }else {
            createSPosition(snake,positions,counter);
        }
        return;
    }

    private void createLPosition(int ladder, int positions, int counter){
        if(ladder==counter){
            return;
        }
        Random rand = new Random();
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 && int_random!=positions-1){
            if(positionArrayL==null){
                positionArrayL.add(int_random);
            }else {
                boolean repeatedS=checkArrayValueS(int_random, 0);
                boolean repeatedL=checkArrayValueL(int_random, 0);
                if(repeatedS==false && repeatedL==false){
                    positionArrayL.add(int_random);
                    createSPosition(ladder, positions, counter+1);
                }else{
                    createSPosition(ladder, positions, counter);
                }
            }
        }else {
            createSPosition(ladder,positions,counter);
        }
        return;
    }

    private boolean checkArrayValueS(int random, int counter){
        if(counter==positionArrayS.size()){
            return false;
        }
        if(random==positionArrayS.get(counter)){
            return true;
        }else {
            checkArrayValueS(random, counter+1);
        }
        return false;
    }

    private boolean checkArrayValueL(int random, int counter){
        if(counter==positionArrayL.size()){
            return false;
        }
        if(random==positionArrayL.get(counter)){
            return true;
        }else {
            checkArrayValueL(random, counter+1);
        }
        return false;
    }


    private void boardPrint(){
    }

}