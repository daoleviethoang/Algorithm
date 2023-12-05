import java.util.Scanner;

public class AliceBobAndChocolate {
    public int[] solve(int n, int[] a) {
        return new int[]{0,0};
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
