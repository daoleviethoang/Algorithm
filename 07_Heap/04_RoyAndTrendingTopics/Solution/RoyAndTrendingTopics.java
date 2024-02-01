import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RoyAndTrendingTopics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<TopicInformation> topicInformations = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            long ID = scanner.nextInt();
            long zScore = scanner.nextInt();
            long post = scanner.nextInt();
            long like = scanner.nextInt();
            long comment = scanner.nextInt();
            long share = scanner.nextInt();

            long newZScore = post * 50L + like * 5L + comment * 10L + share * 20L;
            long changeInZScore = newZScore - zScore;

            topicInformations.add(new TopicInformation(ID, zScore, newZScore, changeInZScore));
        }
        scanner.close();

        topicInformations.sort((o1, o2) -> {
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
        });

        for (int i = 0; i < 5; i++) {
            System.out.println(topicInformations.get(i).ID + " " + topicInformations.get(i).newZScore);
        }
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
    }
}
