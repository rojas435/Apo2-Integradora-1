package model;

public class PlayerLST {

    private Player head;

    public PlayerLST(){
        this.head = null;
    }
    public Player getHead() {
        return head;
    }
    public void setHead(Player head) {
        this.head = head;
    }
    
    public void addPlayer(Player node){
        if(head == null){
            this.head = node;
            node.setNext(node);
        }else{
            addPlayer(node, head);
        }
    }

    public void addPlayer(Player node, Player current){
        if(current.getNext()==head){
            current.setNext(node);
            current.getNext().setNext(head);
        }else{
            addPlayer(node, (Player) current.getNext());
        }
    }

    public boolean symbolPlayer(char symbol){
        return symbolPlayer(symbol, head, 0);
    }

    public boolean symbolPlayer(char symbol, Player current, int i){
        if(head == null){
            return false;
        }
        if(i == 3){
            return false;
        }
        if(current.getId()==symbol){
            return true;
        }else{
            return symbolPlayer(symbol, (Player)current.getNext(), i++);
        }
    }
   
}
