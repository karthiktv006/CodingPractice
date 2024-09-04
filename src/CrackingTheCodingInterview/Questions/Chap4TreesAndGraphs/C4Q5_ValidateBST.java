package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.BinaryTreeNode;
import Common.TreeHelper;

public class C4Q5_ValidateBST {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        BinaryTreeNode root = treeHelper.createBinaryTree();
        System.out.println(validateBST(root, null));
        BinaryTreeNode root2 = treeHelper.createBinarySearchTree();
        System.out.println(validateBST(root2, null));

        System.out.println(checkBST(root2));
    }

    static boolean validateBST(BinaryTreeNode node, Integer last_printed) {

        if (node == null) return true;
        if (!validateBST(node.left, last_printed)) return false;
        if (last_printed != null && node.data <= last_printed) return false;
        last_printed = node.data;
        System.out.println(last_printed);
        if (!validateBST(node.right, last_printed)) return false;
        return true;
    }

    static boolean checkBST(BinaryTreeNode root) {
        return checkBST(root, null, null);
    }

    static boolean checkBST(BinaryTreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data > max)) return false;
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }
}
