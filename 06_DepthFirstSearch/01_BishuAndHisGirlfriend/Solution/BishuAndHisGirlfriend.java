import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class BishuAndHisGirlfriend {
    // static final int MAX = 1002;

    public static int DFS(int n, ArrayList<ArrayList<Integer>> graph, int s, int f) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            visited[i] = false;
            dist[i] = 0;
        } 

        stack.add(s);
        visited[s] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);

                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    stack.add(v);
                }

                
                if (v == f) {
                    return dist[v];
                }
            }
        }
        

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(1, n+2).forEach((int i) -> {
            graph.add(new ArrayList<>());
        });

        IntStream.range(1, n).forEach((int i) -> {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        });

        int q = scanner.nextInt();
        int minLocation = 0;
        int minDist = 0;
        for (int i = 0; i < q; i++) {
            int girlLocation = scanner.nextInt();
            int dist = DFS(n, graph, 1, girlLocation);
            if (dist != -1) {
                if (minLocation == 0) {
                    minLocation = girlLocation;
                    minDist = dist;
                } else {
                    if (dist < minDist) {
                        minLocation = girlLocation;
                        minDist = dist;
                    } else if (dist == minDist) {
                        minLocation = Math.min(minLocation, girlLocation);
                    }
                }
            }
        }
        scanner.close();
        System.out.print(minLocation);
    }    
}
