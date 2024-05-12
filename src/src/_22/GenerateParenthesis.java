package _22;

import java.util.*;

// Gives correct answer
// But not in order that LeetCode expects

public class GenerateParenthesis {
    private final HashMap<Integer, List<String>> cache = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> answer = List.of("()");
            cache.put(1, answer);
            return answer;
        }

        if (!cache.containsKey(n-1)) {
            generateParenthesis(n-1);
        }

        Set<String> currentGeneration = new HashSet<>();
        List<String> previousGeneration = cache.get(n-1);

        for (String parenthesis: previousGeneration) {
            currentGeneration.add("(" + parenthesis + ")");
            currentGeneration.add("()" + parenthesis);
            currentGeneration.add(parenthesis + "()");
        }

        List<String> answer = currentGeneration.stream().toList();
        cache.put(n, answer);
        return answer;
    }
    
    public void driver() {
        int n= 3;
        List<String> answer = generateParenthesis(n);
        System.out.println(answer.toString());
    }
}
