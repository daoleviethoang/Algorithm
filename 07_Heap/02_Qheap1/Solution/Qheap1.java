import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap1 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       int n = scanner.nextInt();
       PriorityQueue<Integer> heap = new PriorityQueue<>();
       PriorityQueue<Integer> heapTmp = new PriorityQueue<>();

       for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                heap.add(scanner.nextInt());
            } else if (type == 2) {
                heapTmp.add(scanner.nextInt());
            } else {
                while (!heapTmp.isEmpty() && heapTmp.peek().equals(heap.peek())) {
                    heapTmp.remove();
                    heap.remove();
                }

                System.out.println(heap.peek());
            }
       }

       scanner.close();
    }
}
