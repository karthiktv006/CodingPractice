package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

public class C4Q4_CheckBalanced {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        BinaryTreeNode root = treeHelper.createBinaryTree();
        System.out.println(checkBalanced(root));
    }

    static boolean checkBalanced(BinaryTreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        } else {
            return checkBalanced(root.left) && checkBalanced(root.right);
        }
    }

    static int getHeight(BinaryTreeNode node) {
        if (node == null) return -1;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        System.out.println(node.data);
        System.out.println("left" + left);
        System.out.println("right" + right);
        System.out.println("max" + (Math.max(left, right) + 1));
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}
