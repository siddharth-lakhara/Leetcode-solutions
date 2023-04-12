package _2405;

import java.util.HashSet;

public class PartitionString {
    public int partitionString(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int[] cache = new int[s.length()];
        cache[0] = 1;
        HashSet<Character> visitedChars = new HashSet<>();
        visitedChars.add(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (visitedChars.contains(s.charAt(i))) {
                cache[i] = 1+cache[i-1];
                visitedChars.clear();
            } else {
                cache[i] = cache[i-1];
            }
            visitedChars.add(s.charAt(i));
        }
        
        return cache[s.length()-1];
    }
    
    public void driver() {
        String s = "abacaba";
        int answer = partitionString(s);
        System.out.println(answer);
    }
}
