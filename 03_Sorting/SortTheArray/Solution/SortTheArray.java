import java.util.Arrays;
import java.util.Scanner;

public class SortTheArray {
    public int[] solve(int n, int[] a) {
        int[] r = new int[2];
        r[0] = 0;
        r[1] = 0;
        int frequece = 0;
    
        int[] aSorted = Arrays.copyOf(a, n);
        Arrays.sort(aSorted);
        for (int i = 0; i < n; i++) {
            if (frequece > 0) {
                r[1]++;
            }
            if (a[i] != aSorted[i]) {
                if (frequece == 0) {
                    r[0] = i;
                    r[1] = i;
                    frequece++;
                }
            } else {
                frequece++;
            }
            if (frequece == 2) {
                break;
            }
        }

        return r;
    }
    public static void main(String[] args) {
        SortTheArray solution = new SortTheArray();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int[] r = solution.solve(n, a);

        if (r[0] == 0 && r[1] == 0) {
            System.out.print("no");
        } else {
            System.out.println("yes");
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
