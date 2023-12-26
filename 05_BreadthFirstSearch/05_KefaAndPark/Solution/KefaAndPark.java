import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KefaAndPark {
    static final int MAX = 100000 + 5;

    public static int BFS(ArrayList<Integer>[] graph, Boolean[] visited, int[] a, int s, int m) {
        int[] frequenceCat = new int[MAX];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        frequenceCat[s] = (a[s] == 1 ? 1 : 0);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    if (a[v] == 1) {
                        frequenceCat[v] = frequenceCat[u] + 1;
                    }
                    if (frequenceCat[v] <= m) {
                        if (graph[v].size() == 1) {
                            count++;
                        } else {
                            q.add(v);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Boolean[] visited = new Boolean[MAX];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] graph = new ArrayList[MAX];

        int[] a = new int[MAX];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        scanner.close();

        System.out.print(BFS(graph, visited, a, 1, m));
    }
}
