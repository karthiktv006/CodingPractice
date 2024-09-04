package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

public class C4Q6_Successor {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        BinaryTreeNode root = treeHelper.createBinarySearchTree();

        successor(root.left.right);
        System.out.println(inOrderSucc(root.right).data);
    }

    static BinaryTreeNode inOrderSucc(BinaryTreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            return leftMostNode(node.right);
        } else {
            BinaryTreeNode q = node;
            BinaryTreeNode p = q.parent;
            while (p != null && p.parent != q) {
                q = p;
                p = p.parent;
            }
            return p;
        }
    }

    static BinaryTreeNode leftMostNode(BinaryTreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    static void successor(BinaryTreeNode node) {
        System.out.println("successor for node:" + node.data);
        if (hasLeftNode(node) && hasRightNode(node)) {
            BinaryTreeNode n = node.right;
            while (n.left != null) {
                n = n.left;
            }
            System.out.println("non-leaf has left n right node next:" + n.data);
        } else if (hasLeftNode(node)) {
            if (isLeftNode(node.parent)) {
                System.out.println("non-leaf has left node next:" + node.parent.parent.data);
            } else {
                System.out.println("no next");
            }
        } else if (hasRightNode(node)) {
            System.out.println("non-leaf has right node next:" + node.right.data);
        } else if (node.left == null && node.right == null) {
            System.out.println("leaf");
            if (isLeftNode(node)) {
                System.out.println("leaf left node next:" + node.parent.data);
            } else {
                BinaryTreeNode p = node.parent;
                System.out.println(p.data);
                if (isLeftNode(p) && p.parent != null) {
                    System.out.println("leaf right node next:" + p.parent.data);
                }
            }
        }
    }

    static boolean isLeftNode(BinaryTreeNode node) {
        return node.parent != null && node.parent == node.parent.left;
    }

    static boolean isRightNode(BinaryTreeNode node) {
        return node.parent != null && node.parent == node.parent.right;
    }

    static boolean hasLeftNode(BinaryTreeNode node) {
        return node.left != null;
    }

    static boolean hasRightNode(BinaryTreeNode node) {
        return node.right != null;
    }
}
