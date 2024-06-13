import java.util.*;

public class DFS {
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void depthFirstSearchUtil(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    depthFirstSearchUtil(n, visited);
            }
        }

        void depthFirstSearch(int v) {
            boolean[] visited = new boolean[V];
            depthFirstSearchUtil(v, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        g.depthFirstSearch(2);
    }
}
