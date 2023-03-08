package model;

import jdk.dynalink.NoSuchDynamicMethodException;
public class Ladders extends Node{
    private String display;
    private Node connect;

    private boolean connected;

    public Ladders(int value) {
        super(value);
        this.display = "[L]";
        this.connected = false;
    }

    public Node getConnect() {return connect;}

    public void setConnect(Node connect) {this.connect = connect;}

    public String getDisplay() {return display;}

    public void setDisplay(String display) {this.display = display;}

    public boolean isConnected() {return connected;}

    public void setConnected(boolean connected) {this.connected = connected;}
}
