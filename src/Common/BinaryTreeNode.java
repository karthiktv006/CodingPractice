package Common;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;
    public boolean marked;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.marked = false;
    }
}
