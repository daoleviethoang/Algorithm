import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TravellingCost {
    static final int MAX = 505;

    public static int[] Dijkstra(ArrayList<ArrayList<Node>> graph, int[] dist, int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist.compareTo(o1.dist);
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
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] dist = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<Node>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        int s = scanner.nextInt();
        int[] r = Dijkstra(graph, dist, s);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int f = scanner.nextInt();
            System.out.println(r[f] != Integer.MAX_VALUE ? r[f] : "NO PATH");
        }
        scanner.close();
    }
}

class Node {
    public Integer id;
    public Integer dist;

    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }
}