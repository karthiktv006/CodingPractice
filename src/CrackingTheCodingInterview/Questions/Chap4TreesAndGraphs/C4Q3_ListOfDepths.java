package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class C4Q3_ListOfDepths {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();

        BinaryTreeNode node = treeHelper.createBinaryTree();
        Hashtable<Integer, LinkedList> table = new Hashtable<>();
        Hashtable<Integer, LinkedList> newtable = listOfDepths(node, 0, table);
        Enumeration<Integer> keys = newtable.keys();
        while (keys.hasMoreElements()) {
            int key = keys.nextElement();
            System.out.println(newtable.get(key));
        }
    }

    static Hashtable<Integer, LinkedList> listOfDepths(BinaryTreeNode node, int depth, Hashtable<Integer, LinkedList> table) {

        if (node == null) return null;
        if (table.get(depth) == null) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(node.data);
            table.put(depth, list);
        } else {
            table.get(depth).add(node.data);
        }

        System.out.println(node.data);
        System.out.println(depth);
        listOfDepths(node.left, depth + 1, table);
        listOfDepths(node.right, depth + 1, table);
        return table;
    }
}
