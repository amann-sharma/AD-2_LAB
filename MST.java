import java.util.*;

public class MST {
    static class Graph {
        int V;
        List<Edge> edges;

        Graph(int V) {
            this.V = V;
            edges = new ArrayList<>();
        }

        static class Edge {
            int src, dest, weight;

            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        void addEdge(int src, int dest, int weight) {
            edges.add(new Edge(src, dest, weight));
        }

        void minimumSpanningTree() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(), Comparator.comparingInt(e -> e.weight));

            for (Edge edge : edges)
                pq.add(edge);

            int[] parent = new int[V];
            for (int i = 0; i < V; i++)
                parent[i] = i;

            int[] rank = new int[V];

            List<Edge> mst = new ArrayList<>();
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                int x = find(parent, edge.src);
                int y = find(parent, edge.dest);

                if (x != y) {
                    mst.add(edge);
                    union(parent, rank, x, y);
                }
            }

            System.out.println("Minimum Spanning Tree:");
            for (Edge edge : mst)
                System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }

        private int find(int[] parent, int i) {
            if (parent[i] != i)
                parent[i] = find(parent, parent[i]);
            return parent[i];
        }

        private void union(int[] parent, int[] rank, int x, int y) {
            int xRoot = find(parent, x);
            int yRoot = find(parent, y);

            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[xRoot] > rank[yRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.minimumSpanningTree();
    }
}
