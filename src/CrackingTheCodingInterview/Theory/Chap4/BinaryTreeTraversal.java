package CrackingTheCodingInterview.Theory.Chap4;


import Common.TreeNode;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(18);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(7);

        n0.setChildren(n1, n2);
        n1.setChildren(n3, n4);
        n2.setChildren(n5, n6);

        System.out.println("In order traversal:");
        inOrderTraversal(n0);
        System.out.println("––––––––");
        System.out.println("Pre order traversal:");
        preOrderTraversal(n0);
        System.out.println("––––––––");
        System.out.println("Post order traversal:");
        postOrderTraversal(n0);



    }

    static public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.children[0]);
            System.out.println(node.data);
            inOrderTraversal(node.children[1]);
        }
    }

    static public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.children[0]);
            preOrderTraversal(node.children[1]);
        }
    }

    static public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.children[0]);
            postOrderTraversal(node.children[1]);
            System.out.println(node.data);
        }
    }
}

