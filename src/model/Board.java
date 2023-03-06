package model;

public class Board {
    private int sizeX;

    private int sizeY;

    private int snakeNum;

    private int laddersNum;

    private Node start;

    private Node end;




    public Board(int rows, int columnas, int snakes, int ladders) {
        this.sizeX = columnas;
        this.sizeY = rows;
        this.snakeNum = snakes;
        this.laddersNum = ladders;
        this.start = null;
        createBoard((columnas*rows), 0);
    }

    private void createBoard(int boardLimit, int boardNodeCounter) {
        boardNodeCounter+=1;
        if(boardNodeCounter<=boardLimit){
            if(boardNodeCounter==snakes){
                Snakes snake = new Snakes(boardNodeCounter);

            } else if(boardNodeCounter==ladders){
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

    private void createSnakePosition(){}

    private void createLadderPosition(){}

    private void boardPrint(){

    }

}