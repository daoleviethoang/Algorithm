import java.util.Scanner;

class NightAtTheMuseum {
    public int solve(String input) {
        int results = 0;
        int pointer = 'a';

        for (int i = 0; i < input.length(); i++) {
            int distance = Math.abs(input.charAt(i) - pointer);
            results += distance < 13 ? distance : (26 - distance);
            pointer = input.charAt(i);
        }

        return results;
    }

    public static void main(String[] args) {
        NightAtTheMuseum solution = new NightAtTheMuseum();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        System.out.print(solution.solve(input));
    }
}
