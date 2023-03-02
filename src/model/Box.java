package model;

public class Box {
    public int id;
    public Box next;
    public Box previous;

    public Box(int id) {
        this.id = id;
        this.next = null;
        this.previous = null;
    }
}