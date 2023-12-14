import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessingQueries {
    public long[] solve(int n, int b, int[][] a) {
        long[] results = new long[n];
        Queue<Long> queue = new LinkedList<>();
        long processing = 0;

        for (int i = 0; i < n; i++) {
            int t = a[i][0];
            int d = a[i][1];

            while (!queue.isEmpty() && queue.peek() <= t) {
                queue.remove();
            }

            if (queue.size() <= b) {
                processing = Math.max(processing, t) + d;
                results[i] = processing;
                queue.add(processing);
            } else {
                results[i] = -1;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        ProcessingQueries solution = new ProcessingQueries();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        scanner.close();

        long[] results = solution.solve(n, b, a);
        for (int i = 0; i < results.length; i++) {
            if (i == results.length - 1) {
                System.out.print(results[i]);
            } else {
                System.out.print(results[i] + " ");
            }
        }
    }
}
