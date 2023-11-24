import java.util.Scanner;

class FashionInBerland {   
    public boolean solve(int n, int[] buttons) {
        if (n == 1) {
            return buttons[0] == 1 ? true : false;
        }

        int countOpen = 0;
        for (int button: buttons) {
            if (button == 0) {
                countOpen++;
            }
            if (countOpen > 1) {
                return false;
            }
        }
        return countOpen == 1 ? true : false;
    }

    public static void main(String[] args) {
        FashionInBerland fashionInBerland = new FashionInBerland();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] buttons = new int[n];

        for (int i = 0; i < n; i++) {
            buttons[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.print(fashionInBerland.solve(n, buttons) ? "YES" : "NO");
    }
}