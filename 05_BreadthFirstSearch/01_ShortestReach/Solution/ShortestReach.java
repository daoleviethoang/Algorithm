import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShortestReach {
    static final int MAX = 1000 + 5;

    public List<Integer> solve(int V, int E, List<List<Integer>> edges, int s) {
        // BFS
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> dist = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            dist.add(0);
            visited.add(false);
            graph.add(new ArrayList<>());
        }

        edges.forEach(edge -> {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        });

        // Thêm đỉnh bắt đầu vào queue, đồng thời duyệt thăm
        visited.set(s, true);
        q.add(s);

        // Duyệt cho tới khi queue empty tức là không còn đỉnh nào để thăm nữa
        while (!q.isEmpty()) {
            // lấy đỉnh trên cùng của queue ra
            int u = q.poll();
            // duyệt qua từng đỉnh kề với đỉnh đang duyệt
            for (int v : graph.get(u)) {
                // lấy đỉnh kề (v) với đỉnh đang được duyệt (u)
                // nếu đỉnh (v) chưa được duyệt thăm, thì thăm và đánh dấu lại
                if (!visited.get(v)) {
                    // đánh dấu đỉnh (v) là đã được thăm
                    visited.set(v, true);
                    // lưu đỉnh (v) vừa duyệt thăm vào mảng danh sách đường đi
                    dist.set(v, dist.get(u) + 1);
                    // thêm đỉnh (v) vào queue để tiếp tục thăm dò mở rộng tới các đỉnh liền kề
                    q.add(v);
                }
            }
        }

        // Sau khi có path thì xuất ra kết quả
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (i == s) {
                continue;
            }

            results.add(visited.get(i) ? dist.get(i) * 6 : -1);
        }

        return results;
    }

    public static void main(String[] args) {
        ShortestReach solution = new ShortestReach();

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            List<List<Integer>> edges = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                edges.add(new ArrayList<>(List.of(u, v)));
            }
            int s = sc.nextInt();
            List<Integer> result = solution.solve(V, E, edges, s);
            System.out.println(result.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
        sc.close();
    }
}
