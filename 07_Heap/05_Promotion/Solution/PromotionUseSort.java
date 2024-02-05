import java.util.Scanner;
import java.util.TreeSet;

public class PromotionUseSort {
    public final static int MAX_K = 1000001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Long> receipts = new TreeSet<>(); 
        int[] frequence = new int[MAX_K];

        int n = scanner.nextInt();
        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();

            for (int j = 0; j < k; j++) {
                Long receipt = scanner.nextLong();
                receipts.add(receipt);
                frequence[receipt.intValue()]++;
            }

            Long min = receipts.first();
            Long max = receipts.last();

            frequence[max.intValue()]--;
            frequence[min.intValue()]--;

            if (frequence[max.intValue()] == 0) {
                receipts.pollLast();
            }
            if (frequence[min.intValue()] == 0) {
                receipts.pollFirst();
            }

            sum += (max - min);
        }
        System.out.println(sum);
        scanner.close();
    }
}
