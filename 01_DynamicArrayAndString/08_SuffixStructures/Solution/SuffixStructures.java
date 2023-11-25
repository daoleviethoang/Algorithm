import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SuffixStructures {
    public String solve(String s, String t) {
        StringBuilder sNew = new StringBuilder();
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        if (s.length() == t.length()) {
            Arrays.sort(charArrayS);
            Arrays.sort(charArrayT);
            if (new String(charArrayS).contains(new String(charArrayT)))
                return "array";
        }

        for (int i = 0; i < s.length(); i++) {
            if (t.contains(s.charAt(i) + "")) {
                sNew.append(s.charAt(i));
            }
        }

        if (sNew.length() < t.length())
            return "need tree";
        // automaton
        if (sNew.length() == t.length()) {
            if (sNew.toString().contains(t))
                return "automaton";
        } else {
            int i = 0;
            StringBuilder sNewTemp = new StringBuilder(sNew);
            while (i < t.length()) {
                if (sNewTemp.length() == t.length() || i == t.length() - 1) {
                    if (sNewTemp.toString().contains(t))
                        return "automaton";
                    else
                        break;
                }
                if (t.charAt(i) != sNewTemp.charAt(i)) {
                    sNewTemp.deleteCharAt(i);
                    i--;
                }
                i++;
            }
        }

        Map<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tMap.get(t.charAt(i) + "") == null) {
                tMap.put(t.charAt(i) + "", 0);
            } else {
                tMap.put(t.charAt(i) + "", tMap.get(t.charAt(i) + "") + 1);
            }
        }

        Set<String> tSet = tMap.keySet();
        for (String c : tSet) {
            int count = 0;
            for (int i = 0; i < sNew.length(); i++) {
                if ((sNew.charAt(i) + "").equals(c)) {
                    count++;
                }
            }
            if (count < tMap.get(c)) {
                return "need tree";
            }
        }

        return "both";
    }

    public static void main(String[] args) {
        SuffixStructures solution = new SuffixStructures();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        System.out.print(solution.solve(s, t));
    }
}