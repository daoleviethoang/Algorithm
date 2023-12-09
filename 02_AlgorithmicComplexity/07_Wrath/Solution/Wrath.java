import java.util.Scanner;
public class Wrath {
    public int solve(int n, int[] a) {
        int lastDie = n;
        int dieCount = 0;
        for (int r = n - 1; r >= 0; r--) {
            if (a[r] >= r) {
                if (r >= lastDie) {
                    dieCount++;
                }
                return n - r - dieCount;
            } else {
                if (r >= lastDie ) {
                    dieCount++;
                }

                if (r - a[r] < lastDie) {
                    lastDie = r - a[r];
                }
            }
        }

        return n - dieCount;
    }

    public static void main(String[] args) {
        Wrath solution = new Wrath();
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
