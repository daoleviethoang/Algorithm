import java.util.Scanner;

public class Solution {
    public int solve(int n, int[] minutes) {

        if (minutes[0] > 15) {
            return 15;
        }

        for (int i = 1; i < n; i ++) {
            if (minutes[i] - minutes[i - 1] > 15) {
                return minutes[i - 1] + 15;
            }
        }

        if (minutes[n - 1] + 15 < 90) {
            return minutes[n - 1] + 15;
        }

        return 90;
    }
    
/*  first solutiob :)
    public int solve2(int n, int[] minutes) {
        int results = 0;

        if (n == 1) {
            if (minutes[0] <= 15) {
                return minutes[0] + 15;
            } else {
                return 15;
            }
        } else {
            if (minutes[0] > 15) {
                return 15;
            } else {
                for (int i = 1; i < minutes.length; i++) {   
                    if (minutes[i] - minutes[i - 1] > 15) {
                        results = minutes[i - 1];
                        break;
                    } else {
                        results = minutes[i];
                    }
                }
        
                return (results + 15) > 90 ? 90 : (results + 15);
            }
        }
    }
 */

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            minutes[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(n, minutes));
    }
}
