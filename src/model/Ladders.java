package model;

import jdk.dynalink.NoSuchDynamicMethodException;
public class Ladders extends Node{
    private String display;
    private Node connect;

    public Ladders(int value) {
        super(value);
        this.display = "[L]";
    }

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

}
