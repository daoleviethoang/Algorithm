import java.util.Scanner;

public class BearAndGame {
    public int solve(int n, int[] minutes) {

        if (minutes[0] > 15) {
            return 15;
        }

        for (int i = 1; i < n; i++) {
            if (minutes[i] - minutes[i - 1] > 15) {
                return minutes[i - 1] + 15;
            }
        }

        if (minutes[n - 1] + 15 < 90) {
            return minutes[n - 1] + 15;
        }

        return 90;
    }

    public static void main(String[] args) {
        BearAndGame solution = new BearAndGame();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            minutes[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(n, minutes));
    }
}
