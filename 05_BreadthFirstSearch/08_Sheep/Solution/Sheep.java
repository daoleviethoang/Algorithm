import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Sheep {
    public static final int[] D_ROW = new int[] { 0, 0, 1, -1 };
    public static final int[] D_COL = new int[] { 1, -1, 0, 0 };

    public static int[] BFS(List<String> graph, Boolean[][] visited, int n, int m, Cell s) {
        boolean haveBorder = false;
        int k = 0;
        int v = 0;
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.row][s.col] = true;

        while (!q.isEmpty()) {
            Cell u = q.poll();

            if (graph.get(u.row).charAt(u.col) == 'k') {
                k++;
            } else if (graph.get(u.row).charAt(u.col) == 'v') {
                v++;
            }

            for (int i = 0; i < 4; i++) {
                int row = u.row + D_ROW[i];
                int col = u.col + D_COL[i];

                if (Cell.isValid(row, n, col, m)
                        && !Cell.isFance(graph.get(row).charAt(col))
                        && !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new Cell(row, col));
                    if (Cell.isBorder(row, col, n, m)) {
                        haveBorder = true;
                    }
                }
            }
        }

        if (haveBorder) {
            return new int[] { k, v };
        } else {
            if (v < k) {
                return new int[] { k, 0 };
            } else {
                return new int[] { 0, v };
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Boolean[][] visited = new Boolean[n][m];
        List<String> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(scanner.nextLine());
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
        scanner.close();

        int k = 0;
        int v = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && !Cell.isFance(graph.get(i).charAt(j))) {
                    int[] r = BFS(graph, visited, n, m, new Cell(i, j));
                    k = k + r[0];
                    v = v + r[1];
                }
            }
        }
        System.out.print(k + " " + v);
    }

    public static class Cell {
        public int row;
        public int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public static boolean isValid(int row, int maxRow, int col, int maxCol) {
            return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
        }

        public boolean equals(Cell c) {
            return this.row == c.row && this.col == c.col;
        }

        public static boolean isFance(char value) {
            return '#' == value;
        }

        public static boolean isBorder(int row, int col, int maxRow, int maxCol) {
            return row == 0 || row == maxRow - 1 || col == 0 || col == maxCol - 1;
        }
    }
}
