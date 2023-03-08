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

    positionListS listS = new positionListS();

    positionListL listL = new positionListL();


    public Board(int rows, int columnas, int snakes, int ladders) {
        this.sizeX = columnas;
        this.sizeY = rows;
        this.snakeNum = snakes;
        this.laddersNum = ladders;
        this.start = null;
        createSPosition(snakes*2,(columnas*rows), 0);
        createLPosition(ladders*2, (columnas*rows), 0);
        createBoard((columnas*rows), 1);
        boardPrint(columnas);
    }

    private void createBoard(int boardLimit, int boardNodeCounter) {
        if(boardNodeCounter<=boardLimit){
            if(listS.searchNode(boardNodeCounter)==true){
                Snakes snake = new Snakes(boardNodeCounter);
                addNode(snake);
            } else if(listL.searchNode(boardNodeCounter)==true){
                Ladders ladder = new Ladders(boardNodeCounter);
                addNode(ladder);
            } else {
                Node node = new Node(boardNodeCounter);
                addNode(node);
            }
            createBoard(boardLimit, boardNodeCounter+1);
        }
        return;
    }

    private void addNode(Node node){
        if(start==null && end==null){
            start = node;
            end = node;
            start.setNext(node);
            end.setPrevious(node);
        } else{
            end.setNext(node);
            node.setPrevious(end);
            end = node;
        }
    }

    private void createSPosition(int snake, int positions, int counter){
        if(snake==counter){
            return;
        }
        Random rand = new Random();
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 && int_random!=1 && int_random!=positions-1){
            if(listS.getHead()==null){
                listS.addLast(new Node(int_random));
                System.out.println(int_random);
            }else {
                if(listS.searchNode(int_random)==false){
                    System.out.println(int_random);
                    listS.addLast(new Node(int_random));
                    createSPosition(snake, positions, counter+1);
                }else{
                    createSPosition(snake, positions, counter);
                }
            }
        }else {
            createSPosition(snake,positions,counter);
            return;
        }

    }

    private void createLPosition(int ladder, int positions, int counter){
        if(ladder==counter){
            return;
        }
        Random rand = new Random();
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 && int_random!=1 && int_random!=positions-1) {
            if (listS.searchNode(int_random) == false) {
                if (listL.searchNode(int_random) == false) {
                    System.out.println(int_random);
                    listL.addLast(new Node(int_random));
                    createLPosition(ladder, positions, counter+1);
                    return;
                }else {
                    createLPosition(ladder,positions,counter);
                    return;
                }
            } else {
                createLPosition(ladder,positions,counter);
                return;
            }
        } else {
            createLPosition(ladder,positions,counter);
            return;
        }
    }

    private void boardPrint(int columns){
        boardPrint(start, 0, columns, "");
        return;
    }
    private void boardPrint(Node current, int counter, int columns, String print){
        if(current==null){
            return;
        }
        counter+=1;
        if(counter>columns){
            System.out.println(print);
            print="";
            counter=1;
        }
        if(current instanceof Snakes){
            print += current.getDisplay()+" ";
        } else if (current instanceof Ladders){
            print += current.getDisplay()+" ";
        } else {
            print += current.getDisplay()+" ";
        }

        boardPrint(current.getNext(), counter, columns, print);
        return;
    }

}