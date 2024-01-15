import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DuduServiceMaker {

    public static boolean DFS(List<ArrayList<Integer>> graph, Boolean[] visited, Boolean[] inPath, int s) {
        visited[s] = true;
        inPath[s] = true;

        for (int v : graph.get(s)) {
            if (visited[v]) {
                if (inPath[v]) {
                    return true;
                }
            } else if (!visited[v]) {
                if (DFS(graph, visited, inPath, v)) {
                    return true;
                }
            }
        }
        inPath[s] = false;
        return false;
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Boolean[] inPath = new Boolean[n + 1];
            Boolean[] visited = new Boolean[n + 1];
            List<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                visited[i] = false;
                inPath[i] = false;
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
            }

            boolean isCyclic = false;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isCyclic = DFS(graph, visited, inPath, i);
                    if (isCyclic) {
                        break;
                    }
                }
            }
            System.out.println(isCyclic ? "YES" : "NO");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        solution();
    }
}
