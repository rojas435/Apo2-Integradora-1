package model;

import jdk.dynalink.NoSuchDynamicMethodException;

public class Snakes extends Node{
    private String display;
    private Node connect;

    public Snakes(int value) {
        super(value);
        this.display = "[S]";
    }

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

}
