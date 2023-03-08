package model;

public class positionListL {
    private Node head;
    private Node tail;

    public void addLast(Node node){
        //caso base
        if(this.head == null && this.tail == null){
            this.head = node;
            this.tail = node;
            this.head.setNext(node);
            this.tail.setPrevious(node);
        } else {
            this.tail.setNext(node);
            node.setPrevious(tail);
            this.tail = node;
            head.setPrevious(tail);
            tail.setNext(head);
        }
    }

    public boolean searchNode(int Svalue){
        return searchNode(head, Svalue);
    }

    public boolean searchNode(Node current, int Svalue){
        if(this.head == null && this.tail == null){
            return false;
        }
        if(current.getId() == Svalue){
            return true;
        }else {
            if(current==tail){
                return false;
            }
        }

        searchNode(current.getNext(), Svalue);
        return false;
    }

    public int listSize(){
        return listSize(head, 0);
    }

    public int listSize(Node current, int counter){
        counter+=1;
        if(current==tail){
            return counter;
        }
        return listSize(current.getNext(), counter);
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