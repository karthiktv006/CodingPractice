package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListNode;

public class C2Q8_LoopDetection {
    public static void main(String[] args) {
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
        n10.setNext(n5); // loop

        C2Q8_LoopDetection solution = new C2Q8_LoopDetection();
        LinkedListNode sol = solution.loopDetection(n1);
        if (sol != null) System.out.println(sol.data);

    }

    private LinkedListNode loopDetection(LinkedListNode node) {
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = node;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
