import java.util.Scanner;

public class VitalyAndStrings {
	public String solve(char[] s, char[] t) {
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == 'z') {
                s[i] = 'a';
            } else {
                s[i]++;
                break;
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (t[i] > s[i]) {
                return String.valueOf(s);
            }
        }

        return "No such string";
	}
    
    public static void main(String[] args) {
        VitalyAndStrings solution = new VitalyAndStrings();
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().toCharArray();
        char[] t = scanner.nextLine().toCharArray();
        scanner.close();
        System.out.print(solution.solve(s, t));
    }
}