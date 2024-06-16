package _2900;

import java.util.ArrayList;
import java.util.List;

public class WordsInLongestSubseq {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        ArrayList<String> longestSubSeq = new ArrayList<>();
        longestSubSeq.add(words[0]);
        for (int idx = 1; idx < groups.length; idx++) {
            if (groups[idx] == groups[idx-1]) {
                longestSubSeq.remove(longestSubSeq.size()-1);
            }
            longestSubSeq.add(words[idx]);
        }
        return longestSubSeq;
    }
    
    public void driver() {
        int n = 4;
        String[] words = new String[]{"a","b","c","d"};
        int[] groups = new int[]{1,0,1,1};
        List<String> answer = getWordsInLongestSubsequence(n, words, groups);
        System.out.println(answer);
    }

}
