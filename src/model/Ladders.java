package model;

public class Ladders extends Node{
    private String display="L";
    private Node connect;

    public Ladders(int value) {
        super(value);
    }

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

}
