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
        createBoard();
    }

    private void createBoard() {
        Node previousA = null;
        
    }

}