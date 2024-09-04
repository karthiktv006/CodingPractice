package Common;

public class TreeNode {
    public int data;
    public TreeNode[] children;

    public TreeNode(int data) {
        this.data = data;
        this.children = new TreeNode[2];
    }

    public void setChildren(TreeNode node1, TreeNode node2) {
        if(node1 != null) children[0] = node1;
        if(node2 != null) children[1] = node2;
    }
}
