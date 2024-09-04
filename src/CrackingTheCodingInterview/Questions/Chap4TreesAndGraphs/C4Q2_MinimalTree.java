package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;

public class C4Q2_MinimalTree {
    public static void main(String[] args) {
        BinaryTreeNode[] arr = new BinaryTreeNode[7];
        arr[0] = new BinaryTreeNode(1);
        arr[1] = new BinaryTreeNode(5);
        arr[2] = new BinaryTreeNode(10);
        arr[3] = new BinaryTreeNode(12);
        arr[4] = new BinaryTreeNode(17);
        arr[5] = new BinaryTreeNode(21);
        arr[6] = new BinaryTreeNode(23);

        BinaryTreeNode root = minimalTree(arr, 0, 6);
        System.out.println(root.data);

    }

    static private BinaryTreeNode minimalTree(BinaryTreeNode[] nodes, int start, int end) {
        if (end < start) return null;
        int mid = (end + start) / 2;
        System.out.println("start:" + start);
        System.out.println("mid:" + mid);
        System.out.println("end:" + end);
        BinaryTreeNode n = null;
        if (nodes[mid] != null) {
            n = nodes[mid];
            n.left = minimalTree(nodes, start, mid - 1);
            n.right = minimalTree(nodes, mid + 1, end);
        }
        return n;
    }
}
