package _2899;

import java.util.ArrayList;
import java.util.List;

public class LastVisitedInteger {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> answer = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        int consecutivePrevCount = 0;

        for (String w: words) {
            if (w.equals("prev")) {
                consecutivePrevCount++;
                int newIdx = nums.size()-consecutivePrevCount;
                if (newIdx < 0) {
                    answer.add(-1);
                } else {
                    answer.add(nums.get(newIdx));
                }
            } else {
                consecutivePrevCount = 0;
                nums.add(Integer.valueOf(w));
            }
        }

        return answer;
    }
    
    public void driver() {
//        List<String> words = List.of("1","prev","2","prev","prev");
        List<String> words = List.of("1","2","prev","prev","prev");
        List<Integer> answer = lastVisitedIntegers(words);
        System.out.println(answer);
    }

}
