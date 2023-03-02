package model;

public class Board {
    public int size;
    public Box init;

    public Board(int size) {
        this.size = size;
        this.init = null;
        createBoard();
    }

    private void createBoard() {
        Box previousA = null;
        for (int i = 1; i <= size; i++) {
            Box newNode = new Box(i);
            if (previousA != null) {
                previousA.next = newNode;
                newNode.previous = previousA;
            } else {
                init = newNode;
            }
            previousA = newNode;
        }
    }
}