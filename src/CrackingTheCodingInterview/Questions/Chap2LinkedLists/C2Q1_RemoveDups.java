package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

import java.util.HashSet;

public class C2Q1_RemoveDups {
    public static void main(String[] args) {
        LinkedListHelper listHelper = new LinkedListHelper();

        LinkedListNode n1 = new LinkedListNode(5);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(7);
        LinkedListNode n4 = new LinkedListNode(5);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        listHelper.printNodes(n1);

        C2Q1_RemoveDups solution = new C2Q1_RemoveDups();
        solution.removeDuplicates(n1);

        listHelper.printNodes(n1);

        n3.setNext(n4);

        solution.removeDuplicateHashSet(n1);
        listHelper.printNodes(n1);


    }

    private void removeDuplicateHashSet(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                previous = n;
                set.add(n.data);
            }
            n = n.next;
        }
    }

    // without using temp hash data
    // this approach is checking the listed list like an array which is
    // inefficient approach, use linkedList advantage to this problem. O(N^2)
    private void removeDuplicates(LinkedListNode head) {
        LinkedListNode n = head;
        if (head == null) return;

        while (n != null) {
            int d = n.data;
            System.out.println("d:" + d);
            LinkedListNode checker = n;
            while (checker.next != null) {
                System.out.println("checker:" + checker.next.data);
                if (checker.next.data == d) {
                    if (checker.next.next == null) {
                        checker.next = null;
                        break;
                    } else {
                        checker.next.setNext(checker.next.next);
                        checker.next.next.setPrevious(checker);
                    }

                }
                    checker = checker.next;

            }
            n = n.next;
        }
    }
}