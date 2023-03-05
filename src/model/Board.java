package model;

public class Board {
    public int size;
    public Node init;

    public Board(int size) {
        this.size = size;
        this.init = null;
        createBoard();
    }

    private void createBoard() {
        Node previousA = null;
        for (int i = 1; i <= size; i++) {
            Node newnode = new Node(i);
            if (previousA != null) {
                previousA.setNext(newnode);
                newnode.setPrevious(previousA);
            } else {
                init = newnode;
            }
            previousA = newnode;
        }
    }
}