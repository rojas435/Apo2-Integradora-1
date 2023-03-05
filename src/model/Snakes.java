package model;

public class Snakes {
    private int id;
    private String display="S";
    private Node connect;

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
