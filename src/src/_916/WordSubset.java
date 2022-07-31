package _916;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSubset {
    private List<String> solve(String[] words1, String[] words2) {
        List<String> answer = new ArrayList<>();
        HashMap<Character, Integer> MergedFreqMap = new HashMap<>();

        for (String word2 : words2) {
            HashMap<Character, Integer> LocalFreqMap = new HashMap<>();
            for (int idx = 0; idx < word2.length(); idx++) {
                char ch = word2.charAt(idx);
                LocalFreqMap.put(ch, LocalFreqMap.getOrDefault(ch, 0) + 1);
            }

            for (Character ch : LocalFreqMap.keySet()) {
                if (MergedFreqMap.containsKey(ch)) {
                    MergedFreqMap.put(ch, Math.max(LocalFreqMap.get(ch), MergedFreqMap.get(ch)));
                } else {
                    MergedFreqMap.put(ch, LocalFreqMap.get(ch));
                }
            }
        }

        for (String word1 : words1) {
            HashMap<Character, Integer> LocalFreqMap = (HashMap<Character, Integer>) MergedFreqMap.clone();
            for (int idx = 0; idx < word1.length(); idx++) {
                char ch = word1.charAt(idx);
                if (LocalFreqMap.containsKey(ch)) {
                    int newValue = LocalFreqMap.get(ch) - 1;
                    if (newValue > 0) {
                        LocalFreqMap.put(ch, newValue);
                    } else {
                        LocalFreqMap.remove(ch);
                    }

                }
            }
            if (LocalFreqMap.keySet().size() == 0) {
                answer.add(word1);
            }
        }

        return answer;
    }

    public void driver() {
        String[] words1 = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] words2 = new String[]{"e","oo"};
        List<String> answer = solve(words1, words2);
        System.out.println(answer);
    }
}
