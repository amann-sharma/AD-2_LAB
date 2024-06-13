import java.util.*;

public class BFS {
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

        void breadthFirstSearch(int s) {
            boolean[] visited = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
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

        System.out.println("Breadth First Traversal starting from vertex 2:");
        g.breadthFirstSearch(2);
    }
}
