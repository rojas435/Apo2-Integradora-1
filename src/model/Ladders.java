package model;

public class Ladders extends Node{
    private int id;
    private String display="L";
    private Node connect;

    public Ladders(int value, int id) {
        super(value);
        this.id = id;
    }

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
