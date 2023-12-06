import java.util.Scanner;

public class AliceBobAndChocolate {
    public int[] solve(int n, int[] t) {
        int pLeft = 0;
        int pRight = n - 1;
        while (true) {
            if (pLeft == pRight) {
                return new int[]{pLeft+1,n-pRight-1};
            } else if (pRight - pLeft == 1) {
                return new int[]{pLeft+1,n-pRight};
            }

            if (t[pLeft] > t[pRight]) {
                t[pLeft] = t[pLeft] - t[pRight];
                pRight--;
            } else if (t[pRight] > t[pLeft]) {
                t[pRight] = t[pRight] - t[pLeft];
                pLeft++;
            } else {
                pLeft++;
                pRight--;
            }
        }
    }

    public static void main(String[] args) {
        AliceBobAndChocolate solution = new AliceBobAndChocolate();
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
