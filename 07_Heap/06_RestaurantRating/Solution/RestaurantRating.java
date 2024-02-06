import java.io.*;
import java.util.*;


public class RestaurantRating {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PriorityQueue<Integer> reviewsHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> reviewsShowedHeap = new PriorityQueue<>();

        int numberOfReviews = 0;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                int x = scanner.nextInt();
                if (!reviewsShowedHeap.isEmpty() && x > reviewsShowedHeap.peek()) {
                    int a = reviewsShowedHeap.poll();
                    reviewsShowedHeap.add(x);
                    reviewsHeap.add(a);
                } else {
                    reviewsHeap.add(x);
                }
                numberOfReviews++;
            } else if (type == 2) {
                int numberOfReviewsShowed = numberOfReviews/3;

                if (numberOfReviewsShowed == 0) {
                    System.out.println("No reviews yet");
                } else {
                    while (reviewsShowedHeap.size() < numberOfReviewsShowed) {
                        reviewsShowedHeap.add(reviewsHeap.poll());
                    }

                    System.out.println(reviewsShowedHeap.peek());
                }
            }
        }
    }    

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st = null;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public MyScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }
 
        boolean hasNext() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String tmp = br.readLine();
                    if (tmp == null)
                        return false;
                    st = new StringTokenizer(tmp);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }
        String next() {
            if (hasNext())
                return st.nextToken();
            return null;
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
