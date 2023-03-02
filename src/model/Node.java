package model; 

public class Node {

	private int id;
    private String display;
    private Node next; 
    private Node previous;
    private Node up;
    private Node down;

	public Node(int value) {
		this.id = value;
        this.display = "[" + value + "]" ;
	}

	public void setValue(int value) {
		this.id = value;
	}

	public int getValue() {
		return id;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString(){
		return "My value is: " + id; 
	}

}
