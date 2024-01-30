import java.util.Scanner;

public class AllIzzWell_BackTracking {
    public final static String sentence = "ALLIZZWELL";
    public final static int[] dx = new int[] {0, 0, 1, 1, 1, -1, -1, -1};
    public final static int[] dy = new int[] {1, -1, 1, 0, -1, 1, 0, -1};
    public static boolean isYes; 
    public static char[][] graph;
    public static boolean[][] visited; 
    public static int maxRow = 0;
    public static int maxCol = 0;

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    public static void Backtrack(int r, int c, int cnt) {
        if (cnt == sentence.length()) {
            isYes = true;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int row = r + dx[i];
            int col = c + dy[i];

            if (isValid(row, col) && graph[row][col] == sentence.charAt(cnt) && !visited[row][col]) {
                visited[row][col] = true;
                Backtrack(row, col, cnt + 1);
                visited[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q-- > 0) {    
            maxRow = sc.nextInt();
            maxCol = sc.nextInt();
            sc.nextLine();

            graph = new char[maxRow][maxCol];
            visited = new boolean[maxRow][maxCol];
            
            for (int i = 0; i < maxRow; i++) {
                graph[i] = sc.nextLine().toCharArray();
            }

            isYes = false;

            for (int i = 0; i < maxRow; i++) {
                for (int j = 0; j < maxCol; j++) {
                    if (graph[i][j] == sentence.charAt(0) && !isYes) {
                        Backtrack(i, j, 1);
                    }
                }
            }

            if (isYes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
