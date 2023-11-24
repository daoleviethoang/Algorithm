package Week01.Lecture01;

import java.util.Scanner;

class Solution {
    public boolean solve(int n, int[] buttons) {
        if (n == 1) {
            return buttons[0] == 1 ? true : false;
        }

        int countOpen = 0;
        for (int button: buttons) {
            if (button == 0) {
                countOpen++;
            }
            if (countOpen > 1) {
                return false;
            }
        }
        return countOpen == 1 ? true : false;
    }
}

class FashionInBerland {   
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] buttons = new int[n];

        for (int i = 0; i < n; i++) {
            buttons[i] = scanner.nextInt();
        }

        System.out.print(solution.solve(n, buttons) ? "YES" : "NO");
    }
}