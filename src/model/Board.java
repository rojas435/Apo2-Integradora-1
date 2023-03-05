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
            Box newBox = new Box(i);
            if (previousA != null) {
                previousA.setNext(newBox);
                newBox.setPrevious(previousA);
            } else {
                init = newBox;
            }
            previousA = newBox;
        }
    }
}