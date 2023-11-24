package Week01.Lecture01;

import java.util.Scanner;

public class BearAndGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            minutes[i] = scanner.nextInt();
        }

        int results = 0;

        if (n == 1) {
            if (minutes[0] <= 15) {
                System.out.print(minutes[0] + 15);
            } else {
                System.out.print(15);
            }
        } else {
            if (minutes[0] > 15) {
                System.out.print(15);
            } else {
                for (int i = 1; i < minutes.length; i++) {   
                    if (minutes[i] - minutes[i - 1] > 15) {
                        results = minutes[i - 1];
                        break;
                    } else {
                        results = minutes[i];
                    }
                }
        
                System.out.print((results + 15) > 90 ? 90 : (results + 15));
            }
        }
    }
}
