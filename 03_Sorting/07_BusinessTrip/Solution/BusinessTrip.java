import java.util.Arrays;
import java.util.Scanner;

public class BusinessTrip {
    public int solve(int k, int[] a) {

        if (k == 0) return 0;

        Arrays.sort(a);

        int results = 0 ;
        for (int i = 11; i >= 0; i--) {
            results += a[i];
            if (results >= k) {
                return 12 - i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        BusinessTrip solution = new BusinessTrip();
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int[] a = new int[12];

        for (int i = 0; i < 12; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(k, a));
    }
}
