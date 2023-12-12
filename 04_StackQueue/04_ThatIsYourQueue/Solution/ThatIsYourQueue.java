import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThatIsYourQueue {
    public void solve() {
        Scanner scanner = new Scanner(System.in);

        int caseNumber = 1;
        while (true) {

            /* Idea
                initial from 1 to Min(c,p)
                number commands (c) depends on number citizen (p)
                    - command = 'N' -> all citizen get from queue p
                    - command = 'E x':
                        - case 1: x new -> add x to queue: x 1 2 3 4 -> move x to end: 1 2 3 4 x
                        - case 2: x old -> add x to queue: x 1 2 x 3 4 -> move x_new to end and remove x_old: 1 2 3 4 x   
            */

            int p = scanner.nextInt();
            int c = scanner.nextInt();

            if (p == 0 && c == 0) {
                break;
            }

            System.out.println("Case " + caseNumber++ + ":");

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= Math.min(c, p); i++) {
                queue.add(i);
            }

            scanner.nextLine();
            for (int i = 0; i < c; i++) {
                String commands = scanner.nextLine();
                char command = commands.charAt(0);

                if (command == 'N') {
                    int tmp = queue.poll();
                    System.out.println(tmp);
                    queue.add(tmp);
                } else {
                    int citizen = Integer.parseInt(commands.substring(2));
                    queue.add(citizen);
                    int n = queue.size();
                    for (int j = 0; j < n - 1; j++) {
                        int tmp = queue.poll();
                        if (tmp != citizen) {
                            queue.add(tmp);
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        ThatIsYourQueue solution = new ThatIsYourQueue();
        solution.solve();
    }
}
