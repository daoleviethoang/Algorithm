import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TheBenefactor {
    public static List<List<Location>> graph;
    public static int numberOfLocation;
    public static int leaf;
    

    public static int DFS(int s) {
        int maxCost = 0;
        int cost[] = new int[numberOfLocation + 1];
        boolean visited[] = new boolean[numberOfLocation + 1];
        Stack<Location> stack = new Stack<>();
        stack.add(new Location(s, 0));
        visited[s] = true;

        while (!stack.isEmpty()) {
            Location u = stack.pop();

            for (Location v: graph.get(u.id)) {
                if(!visited[v.id]) {
                    visited[v.id] = true;
                    cost[v.id] = cost[u.id] + v.len;
                    stack.add(v);

                    if (cost[v.id] > maxCost) {
                        maxCost = cost[v.id];
                        leaf = v.id;
                    }
                }
            }
        }

        return maxCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        while (q-- > 0) {
            graph = new ArrayList<>();
            numberOfLocation = scanner.nextInt();
            for (int i = 0; i <= numberOfLocation; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < numberOfLocation - 1; i++) {
                int source = scanner.nextInt();
                int dest = scanner.nextInt();
                int len = scanner.nextInt();

                graph.get(source).add(new Location(dest, len));
                graph.get(dest).add(new Location(source, len));
            }

            leaf = 0;
            DFS(1);
            int max = DFS(leaf);
            System.out.println(max);
        }
        scanner.close();
    }

    static class Location {
        public int id;
        public int len;
        
        public Location(int id, int len) {
            this.id = id;
            this.len = len;
        }
    }
}
