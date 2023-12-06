import java.util.Scanner;

public class SortTheArray {
    public int[] solve(int n, int[] a) {
        int[] r = new int[2];
        r[0] = 1;
        r[1] = 1;

        int frequence = 0;
        boolean check = false;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                if (check == true) {
                    return new int[] { 0, 0 };
                }
                if (frequence == 0) {
                    r[0] = i;
                    r[1] = i + 1;
                    frequence++;
                } else {
                    r[1]++;
                }
            } else {
                if (a[i] < a[r[0] - 1]) {
                    return new int[] { 0, 0 };
                } else {
                    if (frequence == 1) {
                        check = true;
                    }
                }
            }

        }

        if (r[0] - 2 >= 0) {
            if (a[r[1] - 1] < a[r[0] - 2]) {
                return new int[] { 0, 0 };
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
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
