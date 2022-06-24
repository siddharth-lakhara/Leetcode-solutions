package _3;

import java.util.HashMap;

public class LongestSubstring {
    private int solve(String s) {
        int left = 0;
        int right = 0;
        int maxWindowSize = 0;
        HashMap<Character, Integer> charTracker = new HashMap<>();

        while (right != s.length()) {
            char currentChar = s.charAt(right);
            boolean isAlreadySeen = charTracker.containsKey(currentChar);
            if (isAlreadySeen) {
                int lastSeenIdx = charTracker.get(currentChar);
                left = lastSeenIdx < left ? left : lastSeenIdx + 1;
            }
            charTracker.put(currentChar, right);
            int windowSize = right - left + 1;
            if (windowSize > maxWindowSize) {
                maxWindowSize = windowSize;
            }
            right++;
        }
        return maxWindowSize;
    }
    public void driver() {
        String s = "abba";
        int answer = solve(s);
        System.out.println(answer);
    }
}
