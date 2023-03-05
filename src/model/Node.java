package model; 

public class Node{

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

	public String getDisplay() {return display;}

	public void setDisplay(String display) {this.display = display;}

	public Node getDown() {return down;}

	public void setDown(Node down) {this.down = down;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public Node getNext() {return next;}

	public void setNext(Node next) {this.next = next;}

	public Node getPrevious() {return previous;}

	public void setPrevious(Node previous) {this.previous = previous;}

	public Node getUp() {return up;}

	public void setUp(Node up) {this.up = up;}

	@Override
	public String toString(){
		return "My value is: " + id; 
	}

}
