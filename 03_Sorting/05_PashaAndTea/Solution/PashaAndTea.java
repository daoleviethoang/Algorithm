import java.util.Arrays;
import java.util.Scanner;

public class PashaAndTea {
    public double solve(int n, double w, double[] a) {
        double t = w/(3*n*1.0);
        Arrays.sort(a);
        if (a[0] >= t) {
            if (a[n] < 2*t) {
                return (1.0*n)*a[n] + (1.0*n)*(a[n]/2);
            } else {
                return w;
            }
        } else {
            if (a[n] < 2*a[0]) {
                return (1.0*n)*a[n] + (1.0*n)*(a[n]/2);
            } else {
                return 1.0*n*a[0] + 2.0*n*a[0]; 
            }
        }
    }
    
    public static void main(String[] args) {
        PashaAndTea solution = new PashaAndTea();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double w = scanner.nextDouble();
        double[] a = new double[2*n];
 
        for (int i = 0; i < n*2; i++) {
            a[i] = scanner.nextDouble();
        }
        scanner.close();
 
        System.out.print(solution.solve(n, w, a));
    }
}
