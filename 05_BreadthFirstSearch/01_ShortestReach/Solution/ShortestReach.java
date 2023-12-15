import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ShortestReach {

    public static List<Integer> solve(int u, int v, List<List<Integer>> edges, int s) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            path.add(-1);
            visited.add(false);
        }
        visited.set(s, true);
        q.add(s);
        
        return null;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(line[0]);
                int m = Integer.parseInt(line[1]);

                List<List<Integer>> graph = new ArrayList<>();


                IntStream.range(0, m).forEach(i -> {
                    try {
                        graph.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = ShortestReach.solve(n, m, graph, s);

                System.out.println(result.stream().map(Object::toString).collect(joining(" ")));

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
