package Common;

public class LinkedListHelper {
    public LinkedListNode createLinkedList(int n) {
        LinkedListNode n1 = new LinkedListNode(5);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(7);
        LinkedListNode n4 = new LinkedListNode(3);
        LinkedListNode n5 = new LinkedListNode(8);
        LinkedListNode n6 = new LinkedListNode(0);
        LinkedListNode n7 = new LinkedListNode(4);
        LinkedListNode n8 = new LinkedListNode(12);
        LinkedListNode n9 = new LinkedListNode(17);
        LinkedListNode n10 = new LinkedListNode(19);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);

        return n1;
    }

    public LinkedListNode createPalindrome() {
        LinkedListNode n1 = new LinkedListNode(0);
        LinkedListNode n2 = new LinkedListNode(1);
        LinkedListNode n3 = new LinkedListNode(2);
        LinkedListNode n4 = new LinkedListNode(3);
        LinkedListNode n5 = new LinkedListNode(4);
        LinkedListNode n6 = new LinkedListNode(3);
        LinkedListNode n7 = new LinkedListNode(2);
        LinkedListNode n8 = new LinkedListNode(1);
        LinkedListNode n9 = new LinkedListNode(0);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);

        return n1;
    }



    // print nodes from that node passed as ref head
    public void printNodes(LinkedListNode node) {
        while (node.next != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println(node.data);
    }

}
