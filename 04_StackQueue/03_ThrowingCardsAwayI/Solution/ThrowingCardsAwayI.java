import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThrowingCardsAwayI {
    public void solve(int n) {
        Queue<Integer> queue = new LinkedList<>();

        // Initial queue contains n cards
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        ArrayList<Integer> results = new ArrayList<>();

        // Loop queue until the last card
        // In each iteration:
        // - retrieve and remove top card from queue
        // - add it to results
        // -> meet last card -> done
        // -> Discarded cards is results
        // -> Remaining card is last card
        while (queue.size() != 1) {
            results.add(queue.poll());
            int tmp = queue.poll();
            queue.add(tmp);
        }

        // Print results
        StringBuilder discardedCards = new StringBuilder();
        discardedCards.append("Discarded cards:");
        for (int i = 0; i < results.size(); i++) {
            if (i != results.size() - 1) {
                discardedCards.append(" " + results.get(i) + ",");
            } else {
                discardedCards.append(" " + results.get(i));
            }
        }

        System.out.println(discardedCards.toString());
        System.out.println("Remaining card: " + queue.peek());
    }

    public static void main(String[] args) {
        ThrowingCardsAwayI solution = new ThrowingCardsAwayI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            solution.solve(n);
        }
        scanner.close();
    }
}
