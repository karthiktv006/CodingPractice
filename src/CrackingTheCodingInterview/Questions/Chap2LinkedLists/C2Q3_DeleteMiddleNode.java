package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

public class C2Q3_DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedListHelper listHelper = new LinkedListHelper();
        LinkedListNode node = listHelper.createLinkedList(1);
        C2Q3_DeleteMiddleNode solution = new C2Q3_DeleteMiddleNode();
        listHelper.printNodes(solution.deleteMiddle(node));
    }

    private LinkedListNode deleteMiddle(LinkedListNode n) {
        LinkedListNode slow = n;
        LinkedListNode fast = n;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.prev.next = slow.next;
        slow.next.prev = slow.prev;


        return n;
    }
}
