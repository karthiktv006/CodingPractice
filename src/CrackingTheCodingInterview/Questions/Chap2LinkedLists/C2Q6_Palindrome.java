package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

import java.util.Arrays;
import java.util.Stack;

public class C2Q6_Palindrome {
    public static void main(String[] args) {
        LinkedListHelper listHelper = new LinkedListHelper();
        LinkedListNode list = listHelper.createLinkedList(4);

        C2Q6_Palindrome solution = new C2Q6_Palindrome();
        listHelper.printNodes(list);


        System.out.println(solution.getLength(list));
        listHelper.printNodes(solution.reverseAndClone(list));

        LinkedListNode l1 = listHelper.createPalindrome();
        LinkedListNode l2 = solution.reverseAndClone(l1);

        System.out.println(solution.isEqual(l1, l2));
        System.out.println("===");
        System.out.println(solution.isPalindrome(l1));

        System.out.println("===");

        listHelper.printNodes(l1);

        System.out.println(solution.isPalindromeRecurse(l1, solution.getLength(l1)).result);


    }

    private int getLength(LinkedListNode node) {
        if (node == null) return 0;
        return getLength(node.next) + 1;
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private boolean isEqual(LinkedListNode l1, LinkedListNode l2) {
        while (l1 != null && l2 != null) {
            System.out.println(l1.data + ":" + l2.data);
            if (l1.data != l2.data) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private boolean isPalindrome(LinkedListNode l){
        Stack<Integer> stack = new Stack<>();
        LinkedListNode slow = l;
        LinkedListNode fast = l;
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = stack.pop();
            if (slow.data != top) return false;
            slow = slow.next;
        }
        return true;
    }

    private class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    private Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) {
            return new Result(head, true);
        } else if( length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length -2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);

        res.node = res.node.next;
        return res;
    }
}
