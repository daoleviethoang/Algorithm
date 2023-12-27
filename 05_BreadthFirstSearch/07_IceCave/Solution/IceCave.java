import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class IceCave {
    static final int[] D_ROW = new int[] { 0, 0, 1, -1 };
    static final int[] D_COL = new int[] { 1, -1, 0, 0 }; 
    public static void BFS (List<String> graph, Boolean[][] visited, int n, int m, Cell s, Cell f) {
        int count = 0;
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.row][s.col] = true;
        
        while (!q.isEmpty()) {
            Cell u = q.poll();
            for (int i = 0; i < 4; i++) {
                int row = u.row + D_ROW[i];
                int col = u.col + D_COL[i];
                Cell c = new Cell(row, col);
                if (c.equals(f)) count++;
                if (IceCave.Cell.isValid(c.row, n, c.col, m) && graph.get(c.row).charAt(c.col) == '.' && !visited[c.row][c.col]) {
                    visited[c.row][c.col] = true;
                    q.add(c);
                }
            }
        }

        if (graph.get(f.row).charAt(f.col) == 'X') {
            if (count > 0) {
                System.out.print("YES");
                return;
            }
        } else {
            if (count > 1) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        List<String> graph = new ArrayList<>();
        Boolean[][] visited = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            graph.add(scanner.nextLine());
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }

        Cell s = new Cell(scanner.nextInt()-1, scanner.nextInt()-1);
        Cell f = new Cell(scanner.nextInt()-1, scanner.nextInt()-1);
        scanner.close();

        BFS(graph, visited, n, m, s, f);
    }

    static class Cell {
        public int row;
        public int col;

        public Cell (int row, int col) {
            this.row = row;
            this.col = col;
        }

        static public boolean isValid (int row, int maxRow, int col, int maxCol) {
            return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
        }

        public boolean equals (Cell c) {
            return this.row == c.row && this.col == c.col;
        }
    }
}
