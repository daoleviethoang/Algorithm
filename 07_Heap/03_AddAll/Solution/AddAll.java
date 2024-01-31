import java.util.PriorityQueue;
import java.util.Scanner;

public class AddAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Long> heap = new PriorityQueue<>();

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++) {
                heap.add(scanner.nextLong());
            }


            Long totalCost = 0L;
            while (heap.size() > 1) {
                Long number01 = heap.poll();
                Long number02 = heap.poll();
                totalCost = totalCost + number01 + number02;
                heap.add(number01 + number02);
            }
            System.out.println(totalCost);
            heap.clear();
        }
        scanner.close();
    }    
}
