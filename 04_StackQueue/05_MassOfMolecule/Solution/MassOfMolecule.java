import java.util.Scanner;
import java.util.Stack;

public class MassOfMolecule {
    public int solve(char[] formula) {

        Stack<Integer> results = new Stack<>();
        for (int i = 0; i < formula.length; i++) {
            switch (formula[i]) {
                case '(':
                    results.add(-1);
                    break;
                case 'H':
                    results.add(1);
                    break;
                case 'C':
                    results.add(12);
                    break;
                case 'O':
                    results.add(16);
                    break;
                case ')':
                    int subMass = 0;
                    while (results.peek() != -1) {
                        subMass += results.peek();
                        results.pop();
                    }
                    results.pop();
                    results.add(subMass);
                    break;
                default:
                    int tmp = results.peek();
                    results.pop();
                    results.add(tmp*Integer.parseInt(formula[i] + ""));
                    break;
            }
        }

        int mass = 0;
        for (Integer i: results) {
            mass += i;
        }

        return mass;
    }
    public static void main(String[] args) {
        MassOfMolecule solution = new MassOfMolecule();
        Scanner scanner = new Scanner(System.in);

        char[] formula = scanner.nextLine().toCharArray();
        scanner.close();
        System.out.println(solution.solve(formula));
    }
}
