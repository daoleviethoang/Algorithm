import java.util.HashMap;
import java.util.Scanner;
public class Array {
    public int[] solve(int n, int k, int[] a) {
        HashMap<Integer, Integer> frequenceMap = new HashMap<>();
        int r = -1;

        if (k == 1) {
            return new int[] {1,1};
        }

        for (int i = 0; i < n; i++) {
            if (frequenceMap.get(a[i]) == null) {
                frequenceMap.put(a[i], 1);
            } else {
                frequenceMap.put(a[i], frequenceMap.get(a[i])+1);
            }

            if (frequenceMap.keySet().size() == k) {
                r = i;
                break;
            }
        }

        int l = 1;
        for (int i = 0; i < r; i++) {
            if (frequenceMap.get(a[i]) > 1) {
                l++;
                frequenceMap.put(a[i], frequenceMap.get(a[i]) - 1);
            } else {
                break;
            }
        }

        return r == -1 || r == 0  ? new int[] {-1,-1} : new int[]{l, r + 1};
    }
    
    public static void main(String[] args) {
        Array solution = new Array();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int[] r = solution.solve(n, k, a);
        System.out.print(r[0] + " "  + r[1]);
    }    
}
