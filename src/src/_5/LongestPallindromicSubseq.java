package _5;

public class LongestPallindromicSubseq {

    private String solve(String s) {
        int delta = 1;
        int minIdx = 0;
        int maxIdx = 1;

        for (int i=0; i<s.length(); i++) {
            for (int j=i+delta; j<=s.length(); j++) {
                String substr = s.substring(i, j);
                if (this.isPallindrome(substr)) {
                    delta = j-i;
                    minIdx = i;
                    maxIdx = j;
                }
            }
        }

        return s.substring(minIdx, maxIdx);
    }

    private boolean isPallindrome(String s) {
        StringBuilder s0 = new StringBuilder();
        String s1 = s0.append(s).reverse().toString();
        return s.equals(s1);
    }

    public void driver() {
        String s = "cbbd";
        String answer = solve(s);
        System.out.println(answer);
    }

}
