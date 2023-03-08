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

   private positionListS listS = new positionListS();

   private positionListL listL = new positionListL();

    Random rand = new Random();


    public Board(int rows, int columnas, int snakes, int ladders) {
        this.sizeX = columnas;
        this.sizeY = rows;
        this.snakeNum = snakes;
        this.laddersNum = ladders;
        this.start = null;
        createSPosition((snakes*2),(columnas*rows), 0);
        createLPosition((ladders*2), (columnas*rows), 0);
        createBoard((columnas*rows), 1);
        connectNodes((snakes*2), (ladders*2);
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
        if(node instanceof Ladders || node instanceof Snakes || node instanceof Node){
            if(start==null && end==null){
                start = node;
                end = node;
            } else{
                end.setNext(node);
                node.setPrevious(end);
                end = node;
            }
        }
    }

    private void createSPosition(int snake, int positions, int counter){
        if(snake==counter){
            return;
        }
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 || int_random!=1 || int_random!=positions-1){
            if(listS.getHead()==null){
                System.out.println(int_random);
                listS.addLast(new Snakes(int_random));
                createSPosition(snake, positions, counter+1);
            }else {
                if(listS.searchNode(int_random)==false){
                    System.out.println(int_random);
                    listS.addLast(new Snakes(int_random));
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
        int upperbound = positions;
        int int_random = rand.nextInt(upperbound);
        if(int_random!=0 || int_random!=1 || int_random!=positions-1) {
            if (listS.searchNode(int_random) == false) {
                if (listL.searchNode(int_random) == false) {
                    System.out.println(int_random);
                    listL.addLast(new Ladders(int_random));
                    createLPosition(ladder, positions, counter+1);
                }else {
                    createLPosition(ladder,positions,counter);
                }
                return;
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
        boardPrint(end, columns, columns, "");
        return;
    }
    private void boardPrint(Node current, int counter, int columns, String print){

        counter-=1;
        if(counter<0){
            System.out.println(print);
            print="";
            counter=columns-1;
        }
        if(current==null){
            return;
        }
        if(current instanceof Snakes){
            print += current.getDisplay()+" ";
        } else if (current instanceof Ladders){
            print += current.getDisplay()+" ";
        } else {
            print += current.getDisplay()+" ";
        }

        boardPrint(current.getPrevious(), counter, columns, print);
        if(current==start){
            return;
        }
    }

    private void connectNodes(int snakes, int ladders){
        findNodeS(end, snakes);
        findNodeL(start, ladders);
    }
    private void findNodeS(Node current, int amount){
        if(amount==0){
            return;
        }
        if(current==null){
            return;
        }
        if(this.start == null && this.end == null){
            return;
        }
        if(current instanceof Snakes){
            if(((Snakes) current).isConnected()==false){
                ((Snakes) current).setConnect(findNodeS2(current.getNext(), random(amount), 1));
                ((Snakes) current).setConnected(true);
                findNodeS(current.getPrevious(), amount-2);
            }
        }
        findNodeS(current.getPrevious(), amount);
        return;
    }

    private void findNodeL(Node current, int amount){
        if(amount==0){
            return;
        }
        if(current==null){
            return;
        }
        if(this.start == null && this.end == null){
            return;
        }
        if(current instanceof Ladders){
            if(((Ladders) current).isConnected()==false){
                ((Ladders) current).setConnect(findNodeL2(current.getNext(), random(amount), 1));
                ((Ladders) current).setConnected(true);
                findNodeL(current.getNext(), amount-2);
            }
        }
        findNodeL(current.getNext(), amount);
        return;
    }

    private int random(int amount){
        int upperbound = amount-1;
        int int_random = rand.nextInt(upperbound);
        if(int_random != 0){
            return int_random;
        }
        return random(amount);
    }

    private Node findNodeS2(Node current, int snake, int counter){
        if(current==null){
            return null;
        }
        if(this.start == null && this.end == null){
            return null;
        }
        if(current instanceof Snakes){
            if(((Snakes) current).isConnected()==false){
                if(counter == snake){
                    ((Snakes) current).setConnected(true);
                    return ((Snakes) current);
                }
                return findNodeS2(current.getPrevious(), snake, counter+1);
            }
        }
        return findNodeS2(current.getPrevious(), snake, counter);
    }

    private Node findNodeL2(Node current, int ladder, int counter){
        if(current==null){
            return null;
        }
        if(this.start == null && this.end == null){
            return null;
        }
        if(current instanceof Ladders){
            if(((Ladders) current).isConnected()==false){
                if(counter == ladder){
                    ((Ladders) current).setConnected(true);
                    return ((Ladders) current);
                }
                return findNodeL2(current.getNext(), ladder, counter+1);
            }
        }
        return findNodeL2(current.getNext(), ladder, counter);
    }

}