package Common;

public class GraphNode {
    public int data;
    public boolean marked;
    public GraphNode[] children;

    public GraphNode(int data) {
        this.data = data;
    }
}
