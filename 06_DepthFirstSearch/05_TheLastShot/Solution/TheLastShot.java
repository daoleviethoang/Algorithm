import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TheLastShot {
    public static int DFS(List<List<Integer>> graph, Boolean[] mvVisited, int n, int s) {
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        mvVisited[s] = true;
        visited[s] = true;
        int cnt = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            cnt++;
            for (int v: graph.get(u)) {
                if (!visited[v]) {
                    mvVisited[v] = true;
                    visited[v] = true;
                    stack.add(v);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        Boolean[] mvVisited = new Boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            mvVisited[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
        }
        scanner.close();

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (!mvVisited[i]) { 
                int tmp = DFS(graph, mvVisited, n, i);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        System.out.print(max);
    }
}
