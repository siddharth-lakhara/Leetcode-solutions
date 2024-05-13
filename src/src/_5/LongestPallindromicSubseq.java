package _5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// TLE solution
// Attempt to solve it via 1D DP approach
public class LongestPallindromicSubseq {

    public String longestPalindrome(String s) {
        HashMap<Character, List<Integer>> lastSeenMap = new HashMap<>();

        String answer = "";
        int maxLength = 0;

        for (int idx=0; idx<s.length(); idx++) {
            char currChar = s.charAt(idx);

            int localMaxima = 1;
            String localMaximaStr = Character.toString(currChar);

            if (lastSeenMap.containsKey(currChar)) {
                List<Integer> list = lastSeenMap.get(currChar);
                for (int startIdx: list) {
                    String subStr = s.substring(startIdx, idx+1);
                    if (isPallindrome(subStr)) {
                        if (subStr.length() > localMaxima) {
                            localMaxima = subStr.length();
                            localMaximaStr = subStr;
                        }
                    }
                }
                list.add(idx);
            } else {
                lastSeenMap.put(currChar, new ArrayList<>(List.of(idx)));
            }

            if (localMaxima > maxLength) {
                answer = localMaximaStr;
                maxLength = localMaxima;
            }
        }

        return answer;
    }

    private boolean isPallindrome(String s) {
        StringBuilder s0 = new StringBuilder();
        String s1 = s0.append(s).reverse().toString();
        return s.equals(s1);
    }

    public void driver() {
        String s = "babab";
        String answer = longestPalindrome(s);
        System.out.println(answer);
    }

}
