package Common;

public class TreeHelper {
    public BinaryTreeNode createBinaryTree() {
        BinaryTreeNode node0 = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(67);
        BinaryTreeNode node4 = new BinaryTreeNode(34);
        BinaryTreeNode node5 = new BinaryTreeNode(56);
        BinaryTreeNode node6 = new BinaryTreeNode(78);
        BinaryTreeNode node7 = new BinaryTreeNode(23);
        BinaryTreeNode node8 = new BinaryTreeNode(45);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;

        return node0;

    }

    public BinaryTreeNode createBinarySearchTree() {
        BinaryTreeNode node0 = new BinaryTreeNode(33);
        BinaryTreeNode node1 = new BinaryTreeNode(12);
        BinaryTreeNode node2 = new BinaryTreeNode(45);
        BinaryTreeNode node3 = new BinaryTreeNode(8);
        BinaryTreeNode node4 = new BinaryTreeNode(23);
        BinaryTreeNode node5 = new BinaryTreeNode(37);
        BinaryTreeNode node6 = new BinaryTreeNode(78);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        BinaryTreeNode node8 = new BinaryTreeNode(10);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;

        //set parents
        node1.parent = node0;
        node2.parent = node0;
        node3.parent = node1;
        node4.parent = node1;
        node5.parent = node2;
        node6.parent = node2;
        node7.parent = node3;
        node8.parent = node3;

        return node0;

    }
}
