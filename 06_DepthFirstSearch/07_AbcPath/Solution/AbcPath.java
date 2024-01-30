import java.util.Scanner;
import java.util.Stack;

public class AbcPath {
    public final static String sentence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    public final static int[] dy = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
    public static int MAX_ROW;
    public static int MAX_COL;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int count = 0;

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < MAX_ROW && c < MAX_COL;
    }

    // public static int DFS(int r, int c) {
    //     int cnt = 1;
    //     Stack<Integer[]> stack = new Stack<>();
    //     stack.add(new Integer[]{r,c});
    //     visited[r][c] = true;

    //     while (!stack.isEmpty()) {
    //         Integer[] u = stack.pop();

    //         for (int i = 0; i < 8; i++) {
    //             int row = u[0] + dx[i];
    //             int col = u[1] + dy[i];

    //             if (isValid(row, col) && graph[row][col] == sentence.charAt(cnt) && !visited[row][col]) {
    //                 cnt++;
    //                 visited[row][col] = true;
    //                 stack.add(new Integer[]{row,col});
    //             }
    //         }
    //     }

    //     return cnt;
    // }
    
    public static void Backtrack(int r, int c, int cnt) {
        if (cnt == sentence.length()) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int row = r + dx[i];
            int col = c + dy[i]; 

            if (isValid(row, col) && graph[row][col] == sentence.charAt(cnt) && !visited[row][col]) {
                visited[row][col] = true;
                count = Math.max(cnt + 1, count);
                Backtrack(row, col, cnt + 1);
                visited[row][col] = false;
            }
        }
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

            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = 0; j < MAX_COL; j++) {
                    if (graph[i][j] == sentence.charAt(0)) {
                        Backtrack(i, j, 1);
                    }
                }
            }

            System.out.println("Case " + (numberOfCase++) + ": " + count);
        }
    }
}
