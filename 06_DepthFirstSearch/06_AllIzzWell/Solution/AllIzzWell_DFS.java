import java.util.*;

public class AllIzzWell_DFS {
    static final int MAX = 101;
    static String term = "ALLIZZWELL";
    static int R, C;
    static boolean found;
    static int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dc = {1, -1, 0, 1, -1, 0, 1, -1};
    static boolean[][] visited = new boolean[MAX][MAX];
    static char[][] table = new char[MAX][MAX];

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    public static void DFS(int sr, int sc, int count) {
        if (count == term.length()) {
            found = true;
            return;
        }

        //start: DFS
        visited[sr][sc] = true;
        for (int i = 0; i < 8; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (isValid(r, c) && table[r][c] == term.charAt(count) && !visited[r][c]) {
                DFS(r, c, count + 1);
            }
        }
        //end

        visited[sr][sc] = false; 
    }

    /*
        Backtracking 
        public static void Backtrack(int sr, int sc, int count) {
            if (count == term.length()) {
                found = true;
                return;
            }

            for (int i = 0; i < 8; i++) {
                int r = sr + dr[i];
                int c = sc + dc[i];

                if (isValid(r, c) && table[r][c] == term.charAt(count) && !visited[r][c]) {
                    visited[sr][sc] = true; // <- Backtrack here
                    Backtrack(r, c, count + 1); // <- Backtrack here
                    visited[sr][sc] = false; // <- Backtrack here
                }
            }
        }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            R = sc.nextInt();
            C = sc.nextInt();

            for (int i = 0; i < R; i++) {
                table[i] = sc.next().toCharArray();
                for (int j = 0; j < C; j++) {
                    visited[i][j] = false;
                }
            }

            found = false;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (table[i][j] == term.charAt(0) && !found) {
                        DFS(i, j, 1);
                    }
                }
            }

            System.out.println(found ? "YES" : "NO");
        }
    }
}