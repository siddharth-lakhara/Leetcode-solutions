package _44;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int pIdx = 0;
        for (int sIdx = 0; sIdx<s.length(); sIdx++) {
            if (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx)) {
                pIdx++;
            } else { // wildcard matching
                if (pIdx+1 < p.length() && p.charAt(pIdx+1) == s.charAt(sIdx)) {
                    pIdx++;
                }
//                wildcard * match. no need to check anything
            }
        }
        return true;

    }

    public void driver() {
        String s = "aa";
        String p = "aa";

        boolean answer = isMatch(s, p);
        System.out.println(answer);
    }
}
