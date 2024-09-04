package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

public class C4Q8_FirstCommonAncestor {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        BinaryTreeNode root  = treeHelper.createBinarySearchTree();
        commonAncestor(root.left, root.right);
    }

    static void commonAncestor(BinaryTreeNode node1, BinaryTreeNode node2) {
        BinaryTreeNode n = node1;
        while (n.parent != null) {
            n = n.parent;
            doDFS(n, node2);
        }
    }

    static void doDFS(BinaryTreeNode node, BinaryTreeNode f) {
        if (node == null) return;
        System.out.println(node.data);
        if (f == node) return;
        node.marked = true;
        if (node.left != null && !node.left.marked) {
            doDFS(node.left, f);
        }
        if (node.right != null && !node.right.marked) {
            doDFS(node.right, f);
        }
    }
}
