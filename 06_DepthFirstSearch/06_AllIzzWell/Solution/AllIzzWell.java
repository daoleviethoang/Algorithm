
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AllIzzWell {
	public static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static String sentence = "ALLIZZWELL";

    public static boolean isValid(int row, int maxRow, int col, int maxCol) {
        return row >= 0 && col >= 0 && row < maxRow && col < maxCol;
    }

    public static boolean DFS(List<List<Cell>> graph, int n, int m, Cell s) {
        int cnt = 1;
        boolean[][] visited = new boolean[n][m];
        Stack<Cell> stack = new Stack<>();
        stack.add(s);
        visited[s.row][s.col] = true;

        while (!stack.isEmpty()) {
            Cell u = stack.pop();
            for (int i = 0; i < 8; i++) {
                int row = u.row + dx[i];
                int col = u.col + dy[i];

                if (isValid(row, n, col, m) && !visited[row][col] && sentence.charAt(cnt) == u.value) {
                    visited[row][col] = true;
                    stack.add(new Cell(row, col, graph.get(row).get(col).value));
                    cnt++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            List<List<Cell>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                List<Cell> cells = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    Cell c = new Cell(i, j, s.charAt(j));
                    cells.add(c);
                }
                graph.add(cells);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph.get(i).get(j).value == sentence.charAt(0)) {

                    }
                }
            }
        }
    }

    public static class Cell {
        public int row;
        public int col;
        public char value;
        
        public Cell(int row, int col, char value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
