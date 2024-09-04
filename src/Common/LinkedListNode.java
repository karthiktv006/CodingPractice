package Common;

public class LinkedListNode {
    public LinkedListNode next, prev, last;
    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    public LinkedListNode(int d) {
        data = d;
    }

    public LinkedListNode() {}

    public void setNext(LinkedListNode n) {
        next = n;
        if(this == last){
            last = n;
        }
        if(n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode p) {
        prev = p;
        if(p != null && p.next != this) {
            p.setNext(this);
        }

    }

}
