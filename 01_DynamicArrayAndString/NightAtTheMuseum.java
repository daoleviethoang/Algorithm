import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); 

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
        System.out.print(results);
    }
}
