import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessingQueries {
    public long[] solve(int n, int b, int[][] a) {
        long[] results = new long[n];
        Queue<int[]> queue = new LinkedList<>();
        long s = 0;
        long e = 0;

        for (int i = 0; i < n; i++) {
            int t = a[i][0];
            int d = a[i][1];
            
            if (queue.isEmpty()) {
                if (t >= e) {
                    s = t;
                    e = t + d;
                    results[i] = e;

                } else {
                    queue.add(new int[]{t, d, i});
                }
            } else {
                if (t < e && queue.size() == b) {
                    results[i] = -1;
                } else {
                    while (t >= e && !queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        s = e;
                        e = s + tmp[1];
                        results[tmp[2]] = e;
                    }
                    if (t < e) {
                        queue.add(new int[]{t, d, i});
                    } else {
                        results[i] = t + d;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (tmp[0] > e) {
                e = tmp[0] + tmp[1];
            } else {
                e = e + tmp[1];
            }
            results[tmp[2]] = e;
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
