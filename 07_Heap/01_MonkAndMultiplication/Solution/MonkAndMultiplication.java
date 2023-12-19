import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MonkAndMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Long> r = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            heap.add(scanner.nextInt()*1L);
            if (i >= 2) {
                long max1 = heap.poll();
                long max2 = heap.poll();
                long max3 = heap.poll();
                r.add(max1 * max2 * max3);
                heap.add(max1);
                heap.add(max2);
                heap.add(max3);
            } else {
                r.add(-1*1L);
            }
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            System.out.println(r.get(i));
        }
    }
}
