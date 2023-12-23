import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[] visited = new boolean[101];
        for (int i = 0; i < 101; i++) {
            visited[i] = false;
            // if (i >= 65 && i <= 90) {
            // visited[i]
            // }
        }

        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        if (n < 25) {
            System.out.print("NO");
        } else {
            for (int i = 0; i < s.length(); i++) {
                int c = Character.toUpperCase(s.charAt(i));
                visited[c] = true;
            }

            int count = 0;
            for (int i = 65; i <= 90; i++) {
                if (visited[i])
                    count++;
            }
            if (count == 26) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        }
    }
}
