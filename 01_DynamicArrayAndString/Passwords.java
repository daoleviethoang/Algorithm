import java.util.*;

class Solution {
    public String solve(String s, String t) {
        StringBuilder sNew = new StringBuilder();
        char[] charArrayS= s.toCharArray();
        char[] charArrayT = t.toCharArray();

        if (s.length() == t.length()) {
            Arrays.sort(charArrayS);
            Arrays.sort(charArrayT);
            if (new String(charArrayS).contains(new String(charArrayT)))
                return "array";
        }

        for (int i = 0; i < s.length(); i++) {
            if (t.contains(s.charAt(i)+"")) {
                sNew.append(s.charAt(i));
            }
        }

        //automaton
        if (sNew.length() == t.length()) {
            if (sNew.toString().contains(t))
                return "automaton";
        } else {
            
        }

        Map<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tMap.get(t.charAt(i)+"") == null) {
                tMap.put(t.charAt(i)+"", 0);
            } else {
                tMap.put(t.charAt(i)+"", tMap.get(t.charAt(i)+"")+1);
            }
        }

        Set<String> tSet = tMap.keySet();
        for (String c: tSet) {
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
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        System.out.print(solution.solve(s, t));
    }
}