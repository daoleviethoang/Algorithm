import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int[] solve(int n, int k, String[] passwords, String passwordReal) {
        int[] results = new int[2];
        ArrayList<String> aLess = new ArrayList<>();
        ArrayList<String> aEquals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (passwords[i].length() < passwordReal.length()) {
                aLess.add(passwords[i]);
            } else if (passwords[i].length() == passwordReal.length()) {
                aEquals.add(passwords[i]);
            }
        }

        if (aLess.size() < k) {
            results[0] = aLess.size() + 1;
        } else if (aLess.size() >= k) {
            results[0] = aLess.size() + (aLess.size() / k) * 5 + 1;
        }

        if (aLess.size() + aEquals.size() <= k) {
            results[1] = aLess.size() + aEquals.size();
        } else {
            if (aLess.size() + aEquals.size() % k == 0) {
                results[1] = (aLess.size() + aEquals.size()) + ((aLess.size() + aEquals.size()) / k) * 5 - 1 * 5;
            } else {
                results[1] = (aLess.size() + aEquals.size()) + ((aLess.size() + aEquals.size()) / k) * 5;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        String[] passwords = new String[n];

        for (int i = 0; i < n; i++) {
            passwords[i] = scanner.nextLine();
        }

        String passwordReal = scanner.nextLine();
        scanner.close();

        int[] results = solution.solve(n, k, passwords, passwordReal);

        System.out.print(results[0] + " " + results[1]);
    }
}