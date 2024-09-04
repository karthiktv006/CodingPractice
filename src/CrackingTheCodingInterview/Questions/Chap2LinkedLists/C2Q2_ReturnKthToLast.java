package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

public class C2Q2_ReturnKthToLast {
    public static void main(String[] args) {

        LinkedListHelper listHelper = new LinkedListHelper();
        LinkedListNode list = listHelper.createLinkedList(4);

        C2Q2_ReturnKthToLast solution = new C2Q2_ReturnKthToLast();
        System.out.println(solution.printKthLast2(list, 2));

        System.out.println("kToLast:" + solution.kToLast(list, 3).data);

    }

    // iterative method
    private LinkedListNode kToLast(LinkedListNode n, int k) {

        LinkedListNode front = n;
        LinkedListNode back = n;
        int f_index = 0;
        while (front.next != null) {
            if (f_index == k) break;
            f_index++;
            front = front.next;
        }
        if (f_index != k) return null;

        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }

    private void printKthLast(LinkedListNode n) {
        if (n == null) return;
        System.out.println(n.data);
        printKthLast(n.next);
    }

    // recursive method
    private int printKthLast2(LinkedListNode n, int k) {
        if (n == null) return 0;
        int index = printKthLast2(n.next, k) + 1;
        System.out.println(n.data);
        if (index == k) {
            System.out.println("data: " + n.data);
        }
        return index;

    }
}
