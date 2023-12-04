import java.util.Scanner;

public class SerejaAndDima {
    public int[] solve(int n, int[] a) {
        int serajaScore = 0;
        int dimaScore = 0;

        int pLeft = 0;
        int pRight = n - 1;

        int i = 0;
        while (pLeft <= pRight) {
            int r = 0;
            if (a[pRight] > a[pLeft]) {
                r = a[pRight];
                pRight--;
            } else {
                r = a[pLeft];
                pLeft++;
            }

            if (i % 2 == 0) {
                serajaScore += r;
            } else {
                dimaScore += r;
            }

            i++;
        }

        return new int[]{serajaScore, dimaScore};
    }
    public static void main(String[] args) {
        SerejaAndDima solution = new SerejaAndDima();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        
        int[] r = solution.solve(n, a);
        System.out.print(r[0] + " " + r[1]);
    }
}
