import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Dhoom4 {
    static final int MAX = 100005;

    public static int BFS(int[] keys, int n, int keyOfLock, int keyOfSam) {
        boolean[] visited = new boolean[MAX];
        int[] path = new int[MAX];
        Queue<Integer> q = new LinkedList<>();

        IntStream.range(0, MAX).forEach((int i) -> {
            visited[i] = false;
            path[i] = 0;
        });

        q.add(keyOfSam);
        visited[keyOfSam] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < n; i++) {
                long v = (1L * u * keys[i]) % 100000;
                if (!visited[(int) v]) {
                    path[(int) v] = path[u] + 1;
                    visited[(int) v] = true;
                    q.add((int) v);
                }

                if ((int) v == keyOfLock) {
                    return path[(int) v];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int keyOfSam = scanner.nextInt();
        int keyOfLock = scanner.nextInt();
        int n = scanner.nextInt();

        int[] keys = new int[n];
        IntStream.range(0, n).forEach((int i) -> {
            keys[i] = scanner.nextInt();
        });
        scanner.close();

        System.out.print(BFS(keys, n, keyOfLock, keyOfSam));
    }
}
