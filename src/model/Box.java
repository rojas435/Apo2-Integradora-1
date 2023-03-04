package model; 

public class Box{

	private int id;
    private String display;
	private Box next;
	private Box previous;
	private Box up;
    private Box down;

	public Box(int value) {
		this.id = value;
        this.display = "[" + value + "]" ;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Box getDown() {
		return down;
	}

	public void setDown(Box down) {
		this.down = down;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Box getNext() {
		return next;
	}

	public void setNext(Box next) {
		this.next = next;
	}

	public Box getPrevious() {
		return previous;
	}

	public void setPrevious(Box previous) {
		this.previous = previous;
	}

	public Box getUp() {
		return up;
	}

	public void setUp(Box up) {
		this.up = up;
	}

	@Override
	public String toString(){
		return "My value is: " + id; 
	}

}
