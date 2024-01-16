import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DuduServiceMakerNonRecursive {
    
    // use iterator
    public static boolean dfsDetectCycle(List<ArrayList<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        boolean[] inPath = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            stack.push(i);

            while (!stack.isEmpty()) {
                int u = stack.peek();

                if (!visited[u]) {
                    visited[u] = true;
                    inPath[u] = true;
                } else {
                    inPath[u] = false;
                    stack.pop();
                }

                for (int v: graph.get(u)) {
                    if (!visited[v]) {
                        stack.push(v);
                    } else if (inPath[v]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
            }

            System.out.println(dfsDetectCycle(graph, n) ? "SIM" : "NAO");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        solution();
    }
}
