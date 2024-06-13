import java.util.*;

public class ShortestPath {
    static class Graph {
        int V;
        List<List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        static class Edge {
            int dest, weight;

            Edge(int dest, int weight) {
                this.dest = dest;
                this.weight = weight;
            }
        }

        void addEdge(int src, int dest, int weight) {
            adj.get(src).add(new Edge(dest, weight));
            adj.get(dest).add(new Edge(src, weight));
        }

        void dijkstra(int src) {
            PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.weight));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            pq.add(new Node(src, 0));
            dist[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll().vertex;
                for (Edge neighbor : adj.get(u)) {
                    int v = neighbor.dest;
                    int weight = neighbor.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }

            System.out.println("Shortest distances from source vertex " + src + ":");
            for (int i = 0; i < V; i++)
                System.out.println("Vertex " + i + ": " + dist[i]);
        }

        static class Node {
            int vertex, weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.dijkstra(0);
    }
}
