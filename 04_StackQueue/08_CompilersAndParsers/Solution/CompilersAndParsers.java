import java.util.Scanner;
import java.util.Stack;

public class CompilersAndParsers {
    public int solve(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                stack.add('<');
            } else {
                if (stack.isEmpty()) {
                    return res;
                } else {
                    stack.pop();
                    res = (stack.isEmpty() ? i + 1 : res);
                }
            }
        }

        return res;
    } 
    
    public static void main(String[] args) {
        CompilersAndParsers solution = new CompilersAndParsers();
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            System.out.println(solution.solve(s));
        }
        scanner.close();
    }
}
