import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MiceAndMaze {
    static final int MAX = 101;

    public int Dijkstra(ArrayList<ArrayList<Node>> graph, int[] dist, int s, int f, int t) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.dist;

            for (Node neighbor : graph.get(u)) {
                if (w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                    if (neighbor.id == f) {
                        if (dist[neighbor.id] <= t) {
                            return dist[neighbor.id];
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MiceAndMaze miceAndMaze = new MiceAndMaze();
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<Node>());
        }

        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            graph.get(u).add(miceAndMaze.new Node(v, w));
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == e) {
                count++;
            } else {
                int[] dist = new int[MAX];
                Arrays.fill(dist, Integer.MAX_VALUE);
                int r = miceAndMaze.Dijkstra(graph, dist, i, e, t);
                if (r != Integer.MAX_VALUE) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    class Node {
        public Integer id;
        public Integer dist;

        public Node(Integer id, Integer dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
