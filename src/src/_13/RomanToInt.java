package _13;

import java.util.HashMap;

public class RomanToInt {

    final HashMap<Character, Integer> conversionMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);

    }};

    public int romanToInt(String s) {
        int answer = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char currChar = s.charAt(idx);
            if (idx < s.length() - 1) {
                char nextChar = s.charAt(idx + 1);
                if (currChar == 'I' && (nextChar == 'V' || nextChar == 'X')) {
                    answer -= conversionMap.get(currChar);
                } else if (s.charAt(idx) == 'X' && (nextChar == 'L' || nextChar == 'C')) {
                    answer -= conversionMap.get(currChar);
                } else if (s.charAt(idx) == 'C' && (nextChar == 'D' || nextChar == 'M')) {
                    answer -= conversionMap.get(currChar);
                } else {
                    answer += conversionMap.get(s.charAt(idx));
                }
            } else {
                answer += conversionMap.get(s.charAt(idx));
            }
        }
        return answer;
    }

    public void driver() {
        String s = "LVIII";
        int answer = romanToInt(s);
        System.out.println(answer);
    }

}
