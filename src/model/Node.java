package model; 

public class Node{

	private int id;
    private String display;

	private Node saved;
	private Node next;
	private Node previous;

	public Node(int value) {
		super();
		this.id = value;
        this.display = "[" + value + "]" ;
	}

	public String getDisplay() {return display;}

	public void setDisplay(String display) {this.display = display;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public Node getNext() {return next;}

	public void setNext(Node next) {this.next = next;}

	public Node getPrevious() {return previous;}

	public void setPrevious(Node previous) {this.previous = previous;}


	@Override
	public String toString(){
		return "My value is: " + id; 
	}

}
