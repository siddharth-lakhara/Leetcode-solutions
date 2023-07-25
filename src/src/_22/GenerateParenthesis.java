package _22;

import java.util.*;

// Gives correct answer
// But not in order that LeetCode expects

public class GenerateParenthesis {
    HashMap<Integer, HashSet<String>> cache = new HashMap<>();
    
    public List<String> generateParenthesis(int n) {
        if (cache.containsKey(n)) {
            return new ArrayList<>(cache.get(n));
        }
        if (n==1) {
            List<String> ans = Arrays.asList("()");
            cache.put(1, new HashSet<>(ans));
            return ans;
        }

        if (!cache.containsKey(n-1)) {
            generateParenthesis(n-1);
        }
        HashSet<String> cachedAnswer = cache.get(n-1);

        HashSet<String> answer = new HashSet<>();
        for (String cAns : cachedAnswer) {
            answer.add("()"+cAns);
            answer.add("("+cAns+")");
            answer.add(cAns+"()");
        }
        cache.put(n, answer);
        
        return new ArrayList<>(answer);
    }
    
    public void driver() {
        int n= 4;
        List<String> answer = generateParenthesis(n);
        System.out.println(answer.toString());
    }

}
