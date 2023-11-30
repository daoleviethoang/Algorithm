import java.util.Scanner;

public class VitalyAndStringsFS {
	public String solve(String s, String t) {
        String r = "";
        int indexCheck = -1;
        for (int i = 0; i < s.length(); i++) {
            char cTemp = s.charAt(i);
            if (indexCheck != -1) {
                int k = s.charAt(i) + 1;
                if (k <= 122) {
                    cTemp = (char)k;
                    indexCheck = -1;
                } else {
                    cTemp = 'a';
                }
            }
            int gap = t.charAt(i) - s.charAt(i);

            if (gap > 1) {
                return s.substring(0, i) + (char)(s.charAt(i)+1) + s.substring(i+1, t.length());
            } else if (gap == 1 && i != s.length() - 1) {
                indexCheck = i;
            }

            r += cTemp;
        }

        if (indexCheck != -1) {
            return r.substring(0, indexCheck) + (char)(r.charAt(indexCheck)+1) + r.substring(indexCheck+1, t.length());
        }
        return r;
	}
    
    public static void main(String[] args) {
        VitalyAndStringsFS solution = new VitalyAndStringsFS();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        String r = solution.solve(s, t);
        System.out.print(r.equals(s) ? "No such string" : r);
    }
}