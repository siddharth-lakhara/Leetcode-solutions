package _2260;

import java.util.HashMap;

public class ConsecutiveCards {
    public int minimumCardPickup(int[] cards) {
        int answer = Integer.MAX_VALUE;
        HashMap<Integer, Integer> pickedUp = new HashMap<>();
        for (int currIdx = 0; currIdx < cards.length; currIdx++) {
            if (pickedUp.containsKey(cards[currIdx])) {
                answer = Math.min(
                        currIdx - pickedUp.get(cards[currIdx]) +1,
                        answer
                );
            }
            pickedUp.put(cards[currIdx], currIdx);
        }
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }
    
    public void driver() {
        int[] cards = new int[]{1,4,3,9,4,4};
        int answer = minimumCardPickup(cards);
        System.out.println(answer);
    }
}
