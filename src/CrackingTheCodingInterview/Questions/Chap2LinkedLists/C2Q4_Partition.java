package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

public class C2Q4_Partition {
    public static void main(String[] args) {

        LinkedListHelper listHelper = new LinkedListHelper();
        LinkedListNode node = listHelper.createLinkedList(1);

        C2Q4_Partition solution = new C2Q4_Partition();
        listHelper.printNodes(solution.partition(node, 5));
        System.out.println("–––––––");

        LinkedListNode node2 = listHelper.createLinkedList(1);
        listHelper.printNodes(solution.partition2(node2, 5));

    }

    private LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;

    }

    private LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while (node != null) {
            LinkedListNode next = node.next;

            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }
        tail.next = null;
        return head;

    }
}
