package Week01.Lecture01;

import java.util.Scanner;

class Solution05 {
    public boolean solve(int nA, int nB, int k, int m, int[] A, int[] B) {
        if (B[nB - m] > A[k-1]) {
            return true;
        } else {
            return false;
        }
    }
}

public class Arrays {
    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        Scanner scanner = new Scanner(System.in);
    
        int nA = scanner.nextInt();
        int nB = scanner.nextInt();
    
        int k = scanner.nextInt();
        int m = scanner.nextInt();
    
        int[] A = new int[nA];
        int[] B = new int[nB];
    
    
        for (int i = 0; i < nA; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < nB; i++) {
            B[i] = scanner.nextInt();
        }
    
        System.out.print(solution.solve(nA, nB, k, m, A, B) ? "YES" : "NO");
    }
}
