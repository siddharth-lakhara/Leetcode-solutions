package _242;

import java.util.HashMap;

public class ValidAnagram {

    private boolean solve(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> freqMapS = new HashMap<>();
        for (int idx=0; idx< s.length(); idx++) {
            char x = s.charAt(idx);
            freqMapS.put(x, freqMapS.getOrDefault(x, 0) + 1);
        }
        for (int idx=0; idx< s.length(); idx++) {
            char x = t.charAt(idx);
            if (freqMapS.containsKey(x)) {
                int currCount = freqMapS.get(x);
                if (currCount > 1) {
                    freqMapS.put(x, currCount-1);
                } else {
                    freqMapS.remove(x);
                }
            } else {
                return false;
            }

        }
        return freqMapS.size() == 0;
    }

    public void driver() {
        String s = "rat";
        String t = "car";
        boolean answer = this.solve(s, t);
        System.out.println(answer);
    }

}
