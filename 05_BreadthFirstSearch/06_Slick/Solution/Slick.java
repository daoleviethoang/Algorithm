import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Slick {
    static final int[] D_ROW = { 0, 0, 1, -1 };
    static final int[] D_COL = { 1, -1, 0, 0 };

    public static int BFS (int[][] graph, boolean[][] visited, int n, int m, Cell s) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.row][s.col] = true;
        
        int count = graph[s.row][s.col] == 1 ? 1 : 0;

        while (!q.isEmpty()) {
            Cell u = q.poll();
            for (int i = 0; i < 4; i++) {
                int row = u.row + D_ROW[i];
                int col = u.col + D_COL[i];

                if (Slick.Cell.isValid(row, n, col, m)
                    && graph[row][col] == 1
                    && !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new Cell(row, col));
                    count++;
                }
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            boolean[][] visited = new boolean[n][m];
            int[][] graph = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    graph[i][j] = scanner.nextInt();
                    visited[i][j] = false;
                }
            }

            Map<Integer, Integer> resutls = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        Cell s = new Cell(i, j);
                        int r = BFS(graph, visited, n, m, s);
                        if (r != 0) resutls.put(r, resutls.get(r) == null ? 1 : resutls.get(r) + 1);
                    }
                }
            }

            List<Integer> keyList = resutls.keySet().stream().collect(Collectors.toList());
            Collections.sort(keyList);

            int sum = resutls.values().stream().mapToInt(d -> d).sum();
            System.out.println(sum);
            for (int i: keyList) {
                System.out.println(i + " " + resutls.get(i));
            }
        }
        scanner.close();
    }

    static class Cell {
        public int row;
        public int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Cell c) {
            return this.row == c.row && this.col == c.col;
        }

        public static boolean isValid(int row, int maxRow, int col, int maxCol) {
            return row < maxRow && row >= 0 && col < maxCol && col >= 0;
        }
    }
}
