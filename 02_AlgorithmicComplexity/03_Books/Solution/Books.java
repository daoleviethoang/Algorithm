import java.util.Scanner;

public class Books {
    public int solve(int n, int t, int[] a) {
        int maxNumBooks = 0;
        int time = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            time += a[end];

            while(time > t) {
                time = time - a[start];
                start++;
            } 

            if ((end - start + 1) > maxNumBooks) {
                maxNumBooks = end - start + 1;
            }
        }

        return maxNumBooks;
    }

    public static void main(String[] args) {
        Books solution = new Books();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(solution.solve(n, t, a));
    }
}
