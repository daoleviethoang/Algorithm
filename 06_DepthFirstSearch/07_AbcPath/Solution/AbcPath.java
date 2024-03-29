import java.util.Scanner;

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
    
    public static void DFS(int r, int c, int cnt) {
        count = Math.max(count, cnt);

        if (count == 26) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int row = r + dx[i];
            int col = c + dy[i]; 

            if (isValid(row, col) && graph[row][col] == sentence.charAt(cnt) && !visited[row][col]) {
                visited[row][col] = true;
                DFS(row, col, cnt + 1);
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

            count = 0;
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = 0; j < MAX_COL; j++) {
                    if (graph[i][j] == sentence.charAt(0)) {
                        DFS(i, j, 1);
                    }
                }
            }

            System.out.println("Case " + (numberOfCase++) + ": " + count);
        }
    }
}
