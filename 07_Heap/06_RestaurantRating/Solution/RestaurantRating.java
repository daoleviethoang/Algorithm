import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RestaurantRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> ratingsHeap = new PriorityQueue<>(Collections.reverseOrder());

        // tạo 1 cái min heap chứa các ratings đang show
        // sau đó thêm các rating mới vào heap ratings
        // sau đó check nếu size của heap đang show nhỏ hơn floor thì xóa bên heap đang show và add vào heap mới đồng thời kiểm tra

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();

            int x = 0;
            if (type == 1) {
                x = scanner.nextInt();
                ratingsHeap.add(x);
            } else if (type == 2) {
                int floor = ratingsHeap.size()/3;

                if (floor == 0) {
                    System.out.println("No reviews yet");
                } else {
                    int tmp[] = new int[floor + 1];

                    for (int j = 0; j < floor; j++) {
                        tmp[j] = ratingsHeap.poll();
                    }

                    System.out.println(tmp[floor - 1]);

                    for (int j = 0; j < tmp.length; j++) {
                        ratingsHeap.add(tmp[j]);
                    }
                }
            }
        }
        scanner.close();
    }    
}
