package CrackingTheCodingInterview.Questions.Chap4TreesAndGraphs;

import Common.GraphNode;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class C4Q1_RouteBetweenNodes {
    public static void main(String[] args) {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        n0.children = new GraphNode[]{n1};
        n1.children = new GraphNode[]{n2};
        n2.children = new GraphNode[]{n0, n3};
        n3.children = new GraphNode[]{n2};
        n4.children = new GraphNode[]{n3};

        System.out.println(routeBetweenNodes(n3, n4));


    }

    static boolean routeBetweenNodes(GraphNode node1, GraphNode node2) {
        return findRoute(node1, node2, true) || findRoute(node2, node1, false);
    }

    static boolean findRoute(GraphNode origin, GraphNode destination, boolean flag) {
        Queue<GraphNode> queue = new LinkedList<>();
        origin.marked = flag;
        queue.add(origin);
        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();
            System.out.println(n.data);
            if (n == destination) return true;
            for (GraphNode c: n.children) {
                if (!c.marked || !flag) {
                    c.marked = flag;
                    queue.add(c);
                }
            }
        }
        return false;
    }
}
