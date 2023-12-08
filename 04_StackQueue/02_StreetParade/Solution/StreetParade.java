import java.util.Scanner;
import java.util.Stack;

public class StreetParade {

    public String solve(int n, int[] cars) {

        Stack<Integer> sideStreet = new Stack<>();
        int lastLoveMobiles = 0;

        for (int i = 0; i < n; i++) {
            
            if (cars[i] == 1) {
                lastLoveMobiles = cars[i];
                continue;
            }

            if (sideStreet.empty()) {
                if (cars[i] - lastLoveMobiles > 1) {
                    sideStreet.add(cars[i]);
                } else {
                    lastLoveMobiles = cars[i];
                }               
            } else {
                if (cars[i] > sideStreet.peek()) {
                    if (cars[i] - lastLoveMobiles > 1) {
                        while (!sideStreet.isEmpty()) {
                            if (sideStreet.peek() - lastLoveMobiles > 1) break;
                            lastLoveMobiles = sideStreet.peek();
                            sideStreet.pop();
                        }

                        if (!sideStreet.isEmpty()) {
                            if (cars[i] > sideStreet.peek()) {
                                return "no";
                            }
                        }
                        sideStreet.add(cars[i]);
                        continue;
                    }
                    return "no";
                } else {
                    if (cars[i] == lastLoveMobiles + 1) {
                        lastLoveMobiles = cars[i];
                    } else {
                        sideStreet.add(cars[i]);
                    }
                }
            }
        }
        return "yes";
    }
    
    public static void main(String[] args) {
        StreetParade solution = new StreetParade();
        Scanner scanner = new Scanner(System.in);

        int n;
        int[] a;
        while (true) {
            n = scanner.nextInt();

            if (n == 0) break;

            a = new int [n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solution.solve(n, a));
        }
        scanner.close();
    }
}
