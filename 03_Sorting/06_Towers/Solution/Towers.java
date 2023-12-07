import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Towers {
    public int[] solve(int n, int[] a) {
        HashSet<Integer> distinct = new HashSet<>();
        Arrays.sort(a);
        int maxSameLength = 1;
        int countSame = 1;
        int curLength = -1;

        for (int i = 0; i < n; i++) {
            distinct.add(a[i]);

            if (curLength != a[i]) {
                countSame = 1;
                curLength = a[i];
            } else {
                countSame++;
            }

            if (countSame > maxSameLength) {
                maxSameLength = countSame;
            }
        }

        return new int[]{maxSameLength, distinct.size()};
    }
    public static void main(String[] args) {
        Towers solution = new Towers();
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
