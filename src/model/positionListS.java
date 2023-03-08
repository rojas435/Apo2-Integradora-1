package model;

public class positionListS {
    private Node head;
    private Node tail;

    public void addLast(Node node){
        //caso base
        if(this.head == null && this.tail == null){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }

    }

    public boolean searchNode(int Svalue){
        return searchNode(head, Svalue);
    }

    private boolean searchNode(Node current, int Svalue){
        if(current==null){
            return false;
        }
        if(this.head == null && this.tail == null){
            return false;
        }
        if(current.getId() == Svalue){
            return true;
        }else {
        }

        searchNode(current.getNext(), Svalue);
        return false;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

}
