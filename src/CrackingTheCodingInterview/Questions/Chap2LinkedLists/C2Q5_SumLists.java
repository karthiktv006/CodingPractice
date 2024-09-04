package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

public class C2Q5_SumLists {
    public static void main(String[] args) {
        LinkedListHelper listHelper = new LinkedListHelper();
        LinkedListNode first1 = new LinkedListNode(7);
        LinkedListNode first2 = new LinkedListNode(1);
        LinkedListNode first3 = new LinkedListNode(6);
//        LinkedListNode first4 = new LinkedListNode(3);
        first1.setNext(first2);
        first2.setNext(first3);
//        first3.setNext(first4);

        LinkedListNode second1 = new LinkedListNode(5);
        LinkedListNode second2 = new LinkedListNode(9);
        LinkedListNode second3 = new LinkedListNode(2);
        second1.setNext(second2);
        second2.setNext(second3);

        C2Q5_SumLists solution = new C2Q5_SumLists();
//        listHelper.printNodes(solution.sumLists(first1, second1));

        LinkedListNode n = solution.sumLists2(first1, second1, 0);
        listHelper.printNodes(n);

        //follow up question is yet to be done

    }

    private LinkedListNode sumLists(LinkedListNode first, LinkedListNode second) {
        LinkedListNode result = null;
        LinkedListNode prev = null;
        int carryOver = 0;
        while (first != null || second != null) {
            int sum = 0;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }

            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            sum += carryOver;
            System.out.println(sum);
            carryOver = sum / 10;
            sum = sum % 10;
            LinkedListNode node = new LinkedListNode(sum);
            if (result == null) {
                result = node;
                prev = result;
            } else {
                prev.next = node;
                prev = node;
            }

        }
        return result;
    }

    private LinkedListNode sumLists2(LinkedListNode first, LinkedListNode second, int carry) {
        if (first == null || second == null) return null;
        int sum = first.data + second.data + carry;
        carry = sum / 10;
        System.out.println("start:" + first.data + "+" + second.data + "=" + sum);
        LinkedListNode n = new LinkedListNode(sum % 10);
        n.next = sumLists2(first.next, second.next, carry);
        System.out.println("end:" + first.data + "+" + second.data + "=" + sum);
        return n;
    }
}
