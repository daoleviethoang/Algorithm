import java.util.Scanner;

public class BigSegment {
    public int solve(int[][] segments, int n) {
        int max = 0;
        int maxIndex = 0;
        int lMin = segments[0][0];
        int rMax = segments[0][1];

        for (int i = 0; i < n; i++) {
            if (segments[i][1] - segments[i][0] > max) {
                max = segments[i][1] - segments[i][0];
                maxIndex = i;
            }

            if (segments[i][0] < lMin) {
                lMin = segments[i][0];
            }

            if (segments[i][1] > rMax) {
                rMax = segments[i][1];
            }
        }

        if (segments[maxIndex][0] <= lMin && segments[maxIndex][1] >= rMax) {
            return maxIndex + 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        BigSegment solution = new BigSegment();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] segments = new int[n][2];

        for (int i = 0; i < n; i++) {
            segments[i][0] = scanner.nextInt();
            segments[i][1] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(solution.solve(segments, n));
    }
}
