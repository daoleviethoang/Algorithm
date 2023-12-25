import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TravellingCost {
    static final int MAX = 505;

    public static void Dijkstra(ArrayList<ArrayList<Node>> graph, int[] dist, int[] path, int s) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int n = graph.size();

        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.dist;

            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);

                if (w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                    path[neighbor.id] = u;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        

        int n = scanner.nextInt();

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] dist = new int[505];
        int[] path = new int[505];

        IntStream.range(0, MAX).forEach((int i) -> {
            graph.add(new ArrayList<>());
        });
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        IntStream.range(0, n).forEach((int i) -> {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();

            graph.get(a).add(new Node(b, w));
        });

        int s = scanner.nextInt();
        Dijkstra(graph, dist, path, s);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int f = scanner.nextInt();
            if (dist[f] != Integer.MAX_VALUE) {
                System.out.println("NO PATH");
            } else {
                System.out.println(dist[f]);
            }
        }
    }
}

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;

    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist.compareTo(o.dist);
    }
}