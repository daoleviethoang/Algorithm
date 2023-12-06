import java.util.Arrays;
import java.util.Scanner;

public class Chores {
    public int solve(int n, int a, int b, int[] h) {
        Arrays.sort(h);

        if (h[b] == h[b - 1]) {
            return 0;
        } else if (h[b] > h[b - 1]) {
            return h[b] - h[b - 1];
        }

        return 0;
    }

    public static void main(String[] args) {
        Chores solution = new Chores();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        System.out.print(solution.solve(n, a, b, h));
    }
}
