package _5;

// accepted solution
public class LongestPalindrome {

    boolean[][] cache;
    public String longestPalindrome(String s) {
        cache = new boolean[s.length()][s.length()];
        int maxLength = 1; 
        int start = 0;
        int end = 0;
        
        for (int startIdx = s.length()-1; startIdx>=0; startIdx--) {
            for (int endIdx = s.length()-1; endIdx >= startIdx; endIdx--) {
                if (startIdx == endIdx) {
                    cache[startIdx][endIdx] = true;
                } else if (s.charAt(startIdx) == s.charAt(endIdx)) {
                    if (endIdx-startIdx == 1) {
                        cache[startIdx][endIdx] = true;
                    } else {
                        cache[startIdx][endIdx] = cache[startIdx+1][endIdx-1]; 
                    }
                } else {
                    cache[startIdx][endIdx] = false;
                }
                
//                if palindrome, update metrics
                if (cache[startIdx][endIdx]) {
                    int newLen = endIdx-startIdx+1;
                    if (newLen>maxLength) {
                        maxLength = newLen;
                        start = startIdx;
                        end = endIdx;
                    }
                }                 
            }
        }
        
        return s.substring(start, end+1);
    }
    

    public void driver() {
        String s = "eabbae";
        String answer = longestPalindrome(s);
        System.out.println(answer);
    }

}
