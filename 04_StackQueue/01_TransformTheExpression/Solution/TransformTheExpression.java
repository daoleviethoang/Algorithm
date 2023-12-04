import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TransformTheExpression {
    public ArrayList<String> solve(int n, ArrayList<char[]> fss) {
        ArrayList<String> results = new ArrayList<String>();
        for (char[] fs: fss) {
            String r = "";
            Stack<Character> opStack = new Stack<>();
            for (char f: fs) {
                if (f == '(') {
                } else if (f == ')') {
                    r = r + opStack.peek();
                    opStack.pop();
                } else if (f == '+' || f == '-' || f == '*' || f == '/' || f == '^') {
                    opStack.push(f);
                } else {
                    r = r + f;
                }
            }
            results.add(r);
        }
        return results;
    }
    public static void main(String[] args) {
        TransformTheExpression solution = new TransformTheExpression();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<char[]> fss = new ArrayList<char[]>();
        for (int i = 0; i < n; i++) {
            fss.add(scanner.nextLine().toCharArray());
        }

        ArrayList<String> results = solution.solve(n, fss);
        for (int i = 0; i < results.size(); i++) {
            if (i != results.size() - 1) {
                System.out.println(results.get(i));
            } else {
                System.out.print(results.get(i));
            }
        }

        scanner.close();
    }
}
