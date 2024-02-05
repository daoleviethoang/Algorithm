import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Promotion {
    public final static int MAX_K = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] frequence = new int[MAX_K];

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = scanner.nextInt();

        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();

            for (int j = 0; j < k; j++) {
                Long x = scanner.nextLong();
                maxHeap.add(x);
                minHeap.add(x);
                frequence[x.intValue()]++;
            }

            while (!maxHeap.isEmpty() && frequence[maxHeap.peek().intValue()] == 0) {
                maxHeap.poll();
            }
            Long largest = maxHeap.poll();
            frequence[largest.intValue()]--;


            while (!minHeap.isEmpty() && frequence[minHeap.peek().intValue()] == 0) {
                minHeap.poll();
            }
            Long smallest = minHeap.poll();
            frequence[smallest.intValue()]--;

            Long gap = largest - smallest;
            sum += gap;
        }
        System.out.println(sum);
        scanner.close();
    }
}
