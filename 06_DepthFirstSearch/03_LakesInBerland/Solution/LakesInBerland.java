import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LakesInBerland {
    public static final int[] D_ROW = new int[] { 0, 0, 1, -1};
    public static final int[] D_COL = new int[] { 1, -1, 0, 0};

    public static List<Cell> DFS(Character[][] graph, Boolean[][] visited, int n, int m, Cell s) {
        boolean haveCellBorder = false;
        List<Cell> path = new ArrayList<>();
        Stack<Cell> stack = new Stack<>();
        visited[s.row][s.col] = true;
        stack.add(s);

        while (!stack.isEmpty()) {
            Cell u = stack.pop();
            if (Cell.isBorder(u.row, u.col, n, m)) {
                haveCellBorder = true;
            }
            path.add(u);
            for (int i = 0; i < 4; i++) {
                int row = u.row + D_ROW[i];
                int col = u.col + D_COL[i];
                if (Cell.isValid(row, n, col, m) && graph[row][col] == '.' && !visited[row][col]) {
                    visited[row][col] = true;
                    Cell c = new Cell(row, col);
                    stack.push(c);
                }
            } 
        }

        if (haveCellBorder) return null;
        return path;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        Boolean[][] visited = new Boolean[n][m];
        Character[][] graph = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
                graph[i][j] = line.charAt(j);
            }   
        }
        scanner.close();

        List<List<Cell>> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == '.') {
                    List<Cell> path = DFS(graph, visited, n, m, new Cell(i, j));
                    if (path != null) {
                        paths.add(path);
                    }
                }
            }
        }

        Collections.sort(paths, new Comparator<List<Cell>>() {
            public int compare(List<Cell> a1, List<Cell> a2) {
                return a1.size() - a2.size();
            }
        });

        int count = 0;
        int numberOfLakeNeedFill = paths.size() - k;
        for (int i = 0; i < paths.size(); i++) {
            if (numberOfLakeNeedFill == 0) break;
            for (int j = 0; j < paths.get(i).size(); j++) {
                Cell c = paths.get(i).get(j);
                graph[c.row][c.col] = '*';
                count++;
            }
            numberOfLakeNeedFill--;
        }

        System.out.println(count);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static class Cell {
        public int row = 0;
        public int col = 0;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Cell c) {
            return this.row == c.row && this.col == c.col;
        }

        public static boolean isValid(int row, int maxRow, int col, int maxCol) {
            return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
        }

        public static boolean isBorder(int row, int col, int n, int m) {
            return row == 0 || col == 0 || row == n - 1 || col == m - 1;
        }
    }
}
