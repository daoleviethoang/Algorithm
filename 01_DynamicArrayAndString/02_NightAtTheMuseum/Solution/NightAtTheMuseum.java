import java.util.Scanner;

class NightAtTheMuseum {
    public int solve(String input) {
        int firstRange = Math.abs(97 - input.charAt(0));
        int results = firstRange > 13 ? 26 - firstRange : firstRange;

        if (input.length() != 1) {
            for (int i = 1; i < input.length(); i++) {
                int range = Math.abs(input.charAt(i) - input.charAt(i - 1));
                
                if (range > 13) {
                    results = results + (26 - range);
                } else {
                    results = results + range;
                }
            }   
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
