import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GukiZAndContest {
    public ArrayList<Integer> solve(int n, ArrayList<Integer> scores) {
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> tmpScores = (ArrayList<Integer>) scores.clone();
        Collections.sort(tmpScores, Collections.reverseOrder());
        int[] scoreToTop = new int[2001];

        int curTop = 1;
        int curTopScore = tmpScores.get(0);
        int cnt = 0;

        for (int score: tmpScores) {
            if (score == curTopScore) {
                cnt++;
            } else if (score < curTopScore) {
                curTopScore = score;
                int nextTop = curTop + cnt;
                curTop = nextTop;
                cnt = 1;
            }
            scoreToTop[score] = curTop;
        }

        for (int score: scores) {
            r.add(scoreToTop[score]);
        }

        return r;
    }
    
    public static void main(String[] args) {
        GukiZAndContest solution = new GukiZAndContest();
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores.add(scanner.nextInt());
        }
        scanner.close();

        ArrayList<Integer> r = solution.solve(n, scores);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(r.get(i));
            } else {
                System.out.print(r.get(i) + " ");
            }
        }
    } 
}
