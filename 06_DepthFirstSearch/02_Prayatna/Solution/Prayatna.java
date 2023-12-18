import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Prayatna {
    public static void DFS(ArrayList<Integer>[] graph, int s, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        visited[s] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();

            ArrayList<Integer> graph[] = new ArrayList[n];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                visited[i] = false;
            }

            for (int i = 0; i < e; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    DFS(graph, i, visited);
                    count++;
                }
            }

            System.out.println(count);
        }
        scanner.close();
    }
}
