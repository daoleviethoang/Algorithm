import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GuiltyPrince {
    static final int[] D_ROW = { 0, 0, 1, -1 };
    static final int[] D_COL = { 1, -1, 0, 0 };

    public static boolean[][] BFS(List<String> ways, boolean[][] visited, Cell s, int h, int w) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.row][s.column] = true;
        while (!q.isEmpty()) {
            Cell u = q.poll();
            for (int i = 0; i < 4; i++) {
                int row = u.row + D_ROW[i];
                int column = u.column + D_COL[i];

                if (GuiltyPrince.Cell.isValid(row, h, column, w) 
                && ways.get(row).charAt(column) == '.' 
                && !visited[row][column]) {
                    visited[row][column] = true;
                    q.add(new Cell(row, column));
                } 
            }
        }

        return visited;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int c = 1; c<=t; c++) {
            Cell s = null;

            // read number of columns
            int w = scanner.nextInt();
            // read number of rows
            int h = scanner.nextInt();
            // read trash row
            scanner.nextLine();

            List<String> ways = new ArrayList<>();
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                // read data in line
                String line = scanner.nextLine();
                // create ways like graph
                ways.add(line);
                // get start cell and fill all value in visited is false
                for (int j = 0; j < w; j++) {
                    if (line.charAt(j) == '@') {
                        s = new Cell(i, j);
                    }
                    visited[i][j] = false;
                }
            }

            // Breath First Search in ways, and get visited
            visited = BFS(ways, visited, s, h, w);

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j]) {
                        count++;
                    }
                }
            }

            System.out.println("Case " + c + ": " + count);
        }
    }

    public static class Cell {
        public int row;
        public int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public boolean equals(Cell o) {
            return this.row == o.row && this.column == o.column;
        }

        public static boolean isValid(int row, int maxRow, int col, int maxCol) {
            return row < maxRow && row >= 0 && col < maxCol && col >= 0;
        }
    }
}
