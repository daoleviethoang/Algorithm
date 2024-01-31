import java.util.Scanner;
import java.util.Stack;

public class AbcPathDfsNonRecursion {
    public final static int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    public final static int[] dy = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
    public static int MAX_ROW;
    public static int MAX_COL;
    public static char[][] graph;
    public static boolean[][] visited;

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < MAX_ROW && c < MAX_COL;
    }
    
    public static int DFS(int r, int c) {
        char endChar = 'A';
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r,c});
        visited[r][c] = true;

        while (!stack.isEmpty()) {
            int[] u = stack.pop();

            for (int i = 0; i < 8; i++) {
                int row = u[0] + dx[i];
                int col = u[1] + dy[i];

                if (isValid(row, col) && (graph[row][col] == graph[u[0]][u[1]] + 1) && !visited[row][col]) {
                    endChar = graph[row][col] > endChar ? graph[row][col] : endChar;
                    visited[row][col] = true;
                    stack.add(new int[]{row,col});
                }
            }
        }

        return endChar - 'A' + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int numberOfCase = 1;
        while (true) {
            MAX_ROW = scanner.nextInt();
            MAX_COL = scanner.nextInt();            
            if (MAX_ROW == 0 && MAX_COL == 0) {
                break;
            }
            scanner.nextLine();    

            visited = new boolean[MAX_ROW][MAX_COL];
            graph = new char[MAX_ROW][MAX_COL];
            for (int i = 0; i < MAX_ROW; i++) {
                graph[i] = scanner.nextLine().toCharArray();
            }

            int count = 0;
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = 0; j < MAX_COL; j++) {
                    if (graph[i][j] == 'A') {
                        count = Math.max(count, DFS(i, j));
                    }
                }
            }

            System.out.println("Case " + (numberOfCase++) + ": " + count);
        }
    }
}
