import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ValidateTheMaze {
    static final int MAX = 21;
    static final int[] D_ROW = { 0, 0, 1, -1 };
    static final int[] D_COL = { 1, -1, 0, 0 };

    public static boolean BFS(List<String> maze, boolean[][] visited, Cell s, Cell f, int m, int n) {
        Queue<Cell> q = new LinkedList<>();
        visited[s.getRow()][s.getColumn()] = true;
        q.add(s);

        while (!q.isEmpty()) {
            Cell u = q.poll();

            if (u.equals(f)) {
                return true;
            }

            IntStream.range(0, 4).forEach((int i) -> {
                int row = u.getRow() + D_ROW[i];
                int column = u.getColumn() + D_COL[i];

                if (Cell.isValid(row, m, column, n) && maze.get(row).charAt(column) == '.' && !visited[row][column]) {
                    visited[row][column] = true;
                    q.add(new Cell(row, column));
                }
            });
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        boolean[][] visited = new boolean[MAX][MAX];

        ArrayList<String> results = new ArrayList<>();
        while (t-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();

            List<String> maze = new ArrayList<>();
            ArrayList<Cell> gates = new ArrayList<>();
            IntStream.range(0, m).forEach((int i) -> {
                maze.add(scanner.nextLine());
                IntStream.range(0, n).forEach((int j) -> {
                    visited[i][j] = false;
                    if ((i == 0 || j == n - 1 || i == m - 1 || j == 0) && maze.get(i).charAt(j) == '.') {
                        gates.add(new Cell(i, j));
                    }
                });
            });

            if (gates.size() != 2) {
                results.add("invalid");
            } else {
                results.add(BFS(maze, visited, gates.get(0), gates.get(1), m, n) ? "valid" : "invalid");
            }
        }
        results.forEach(System.out::println);
        scanner.close();
    }
}