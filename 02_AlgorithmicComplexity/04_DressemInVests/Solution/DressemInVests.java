import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DressemInVests {
    public List<int[]> solve(int n, int m, int x, int y, int[] a, int[] b) {
        List<int[]> results = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < m && i < n) {
            if (a[i] - x <= b[j] && a[i] + y >= b[j]) {
                int[] r = new int[2];
                r[0] = i + 1;
                r[1] = j + 1;
                results.add(r);
                i++;
                j++;
            } else if (b[j] > (a[i] + y)) {
                i++;
            } else if (b[j] < (a[i] + x)) {
                j++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        DressemInVests solution = new DressemInVests();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        scanner.close();

        List<int[]> results = solution.solve(n, m, x, y, a, b);
        System.out.println(results.size());
        for (int[] i : results) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
