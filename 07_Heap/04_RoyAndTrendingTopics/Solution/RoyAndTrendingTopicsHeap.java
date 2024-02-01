import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RoyAndTrendingTopicsHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        PriorityQueue<TopicInformation> heap = new PriorityQueue<TopicInformation>(new Comparator<TopicInformation>() {
            @Override
            public int compare(TopicInformation o1, TopicInformation o2) {
                if (o2.changeInZScore > o1.changeInZScore) {
                    return 1;
                } else if (o2.changeInZScore < o1.changeInZScore) {
                    return -1;
                } else {
                    if (o2.ID > o1.ID) {
                        return 1;
                    } else if(o2.ID < o1.ID) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < n; i++) {

            long ID = scanner.nextInt();
            long zScore = scanner.nextInt();
            long post = scanner.nextInt();
            long like = scanner.nextInt();
            long comment = scanner.nextInt();
            long share = scanner.nextInt();

            long newZScore = post * 50L + like * 5L + comment * 10L + share * 20L;
            long changeInZScore = newZScore - zScore;

            heap.add(new TopicInformation(ID, zScore, newZScore, changeInZScore));
        }
        scanner.close();

        IntStream.range(0, 5).forEach((int i) -> {
            TopicInformation topic = heap.poll();
            System.out.println(topic.toString());
        });
    }
    
    static class TopicInformation {
        long ID;
        long oldZScore;
        long newZScore;
        long changeInZScore;

        public TopicInformation(long ID, long oldZScore, long newZScore, long changeInZScore) {
            this.ID = ID;
            this.oldZScore = oldZScore;
            this.newZScore = newZScore;
            this.changeInZScore = changeInZScore;
        }

        @Override
        public String toString() {
            return this.ID + " " + this.newZScore;
        }
    }
}
