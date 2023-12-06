import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class DevuTheDumbGuy {
    public long solve(int n, int x, Integer[] c) {
        Arrays.sort(c);
        long time = 0;
        for (int i = 0; i < n; i++) {
            time += (long) x * (long) c[i];
            if (x > 1) {
                x = x - 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        DevuTheDumbGuy solution = new DevuTheDumbGuy();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        Integer[] c = new Integer[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.print(solution.solve(n, x, c));
    }
}
