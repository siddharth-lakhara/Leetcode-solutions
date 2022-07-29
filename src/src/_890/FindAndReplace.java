package _890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplace {
    private List<String> solve(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();

        for (String word : words) {
            HashMap<Character, Character> wordMapper = new HashMap<>();
            HashMap<Character, Character> patternMapper = new HashMap<>();
            char[] wordCopy = new char[word.length()];

            for (int idx = 0; idx < word.length(); idx++) {
                Character replacerChar = wordMapper.getOrDefault(word.charAt(idx), pattern.charAt(idx));
                if (replacerChar != pattern.charAt(idx)) {
                    break;
                }
                Character alreadyReplacedChar = patternMapper.get(replacerChar);
                if (alreadyReplacedChar == null || alreadyReplacedChar == word.charAt(idx)) {
                    wordCopy[idx] = replacerChar;
                    wordMapper.put(word.charAt(idx), pattern.charAt(idx));
                    patternMapper.put(pattern.charAt(idx), word.charAt(idx));
                } else {
                    break;
                }
            }

            if (String.valueOf(wordCopy).equals(pattern)) {
                answer.add(word);
            }
        }
        return answer;
    }

    public void driver() {
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> answer = solve(words, pattern);
        System.out.println(answer);
    }
}
