import java.util.Scanner;

public class ApproximatingAConstantRange {
    public int solve(int n, int[] a) {

        return 0;
    }

    public static void main(String[] args) {
        ApproximatingAConstantRange solution = new ApproximatingAConstantRange();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(n, a));
    }
}
