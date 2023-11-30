import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GeorgeAndRound {
    public int solve(int n, int m, int[] a, int[] b) {
        int start = 0;

        for (int end = 0; end < m; end++) {
            if (b[end] >= a[start]) {
                start++;
            }

            if (start == n) {
                return 0;
            }
        }

        return n - start;
    }

    public static void main(String[] args) {
        GeorgeAndRound solution = new GeorgeAndRound();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i ++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(n, m, a, b));
    }    
}
