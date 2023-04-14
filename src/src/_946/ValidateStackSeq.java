package _946;

import java.util.HashSet;
import java.util.Stack;

public class ValidateStackSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushPointer = 0;
        int popPointer = 0;

        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        
        while (popPointer < popped.length) {
            if (!st.empty() &&  popped[popPointer] == st.peek()) {
                st.pop();
                popPointer++;
            } else if (pushPointer < pushed.length) {
                if (visited.contains(popped[popPointer])) {
                    return false;
                } else if (pushed[pushPointer] == popped[popPointer]) {
                    pushPointer++;
                    popPointer++;
                } else {
                    st.push(pushed[pushPointer]);
                    visited.add(pushed[pushPointer]);
                    pushPointer++;
                }
            } else {
                return false;
            }
            
            
        }
        
        return st.empty();
    }
    
    public void driver() {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,1,2};
        boolean answer = validateStackSequences(pushed, popped);
        System.out.println(answer);
        
    }
}
