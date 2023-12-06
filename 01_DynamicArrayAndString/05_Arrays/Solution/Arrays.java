import java.util.Scanner;

public class Arrays {
    public boolean solve(int nA, int nB, int k, int m, int[] A, int[] B) {
        if (B[nB - m] > A[k - 1]) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Arrays solution = new Arrays();
        Scanner scanner = new Scanner(System.in);

        int nA = scanner.nextInt();
        int nB = scanner.nextInt();

        int k = scanner.nextInt();
        int m = scanner.nextInt();

        int[] A = new int[nA];
        int[] B = new int[nB];

        for (int i = 0; i < nA; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < nB; i++) {
            B[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.print(solution.solve(nA, nB, k, m, A, B) ? "YES" : "NO");
    }
}
