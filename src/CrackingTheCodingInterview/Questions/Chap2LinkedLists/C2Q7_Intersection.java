package CrackingTheCodingInterview.Questions.Chap2LinkedLists;

import Common.LinkedListHelper;
import Common.LinkedListNode;

public class C2Q7_Intersection {

    private class Result {
        LinkedListNode node;
        int length;
        public Result(LinkedListNode node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(0);
        LinkedListNode n2 = new LinkedListNode(1);
        LinkedListNode n3 = new LinkedListNode(2);
        LinkedListNode n4 = new LinkedListNode(3);
        LinkedListNode n5 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        LinkedListNode m1 = new LinkedListNode(0);
        LinkedListNode m2 = new LinkedListNode(1);

        m1.setNext(m2);
        m2.setNext(n4);

        C2Q7_Intersection solution = new C2Q7_Intersection();
        System.out.println(solution.getTailAndLength(n1).length);
        System.out.println(solution.getKthNode(m1, 2).data);


        System.out.println(solution.intersection(n1, m1).data);

    }

    private LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2) {
        Result tail1 = getTailAndLength(node1);
        Result tail2 = getTailAndLength(node2);

        if (tail1.node != tail2.node) return null;

        if (tail1.length >= tail2.length) {
            node1 = getKthNode(node1, tail1.length - tail2.length);
            System.out.println(node1.data);
        } else {
            node2 = getKthNode(node2, tail2.length - tail1.length);
        }

        System.out.println(getTailAndLength(node1).length);
        System.out.println(getTailAndLength(node2).length);

        while (node1 != null) {
            if (node1.next == node2.next) return node1.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    private Result getTailAndLength(LinkedListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return new Result(node, len);
    }

    private LinkedListNode getKthNode(LinkedListNode node, int k) {
        LinkedListNode n = null;
        int index = 0;
        while (node != null) {
            if (index == k) return node;
            index++;
            node = node.next;
        }

        return n;
    }


}
