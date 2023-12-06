import java.util.Scanner;

public class AliceBobAndChocolate {
    public int[] solve(int n, int[] t) {
        int pLeft = 0;
        int pRight = n - 1;
        int curTimeAlice = t[0];
        int curTimeBob = t[n-1];
        int lastTimeAlice = 0;
        int lastTimeBob = 0;
        while (pLeft < pRight) {
            if (curTimeAlice > curTimeBob) {
                lastTimeAlice = curTimeAlice - curTimeBob;
                curTimeAlice = ;
                lastTimeBob = 0;
                pLeft++;
            } else if (curTimeBob > curTimeAlice) {
                lastTimeBob = lastTimeBob - lastTimeAlice;
                lastTimeAlice = 0;
                pRight--;
            } else {
                pLeft++;
                pRight--;
            }
        }
        return new int[]{pLeft+1, n-pRight};
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
