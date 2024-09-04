package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

import java.util.ArrayList;
import java.util.LinkedList;

public class C4Q9_BSTSequences {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        BinaryTreeNode root = treeHelper.createBinarySearchTree();
        LinkedList<Integer> left = new LinkedList<>();
        left.add(2);
        left.add(4);

        LinkedList<Integer> right = new LinkedList<>();
        right.add(6);
        right.add(7);

        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> prefix = new LinkedList<Integer>();

//        weaveLists(left, right, result, prefix);


        allSequences(root);




    }

    static ArrayList<LinkedList<Integer>> allSequences(BinaryTreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            System.out.println(result);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
