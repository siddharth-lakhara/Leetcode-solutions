package _739;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    private record StackElement(int temp, int idx){}

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<StackElement> st = new Stack<>();
        int[] answer = new int[temperatures.length];

        st.push(new StackElement(temperatures[0], 0));
        for (int idx = 1; idx<temperatures.length; idx++) {
            while (!st.isEmpty() && temperatures[idx] > st.peek().temp) {
                answer[st.peek().idx] = idx-st.peek().idx;
                st.pop();
            }
            st.push(new StackElement(temperatures[idx], idx));
        }

        while (!st.isEmpty()) {
            answer[st.peek().idx] = 0;
            st.pop();
        }

        return answer;
    }

    public void driver() {
//        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] temperatures = new int[]{30,40,50,60};
        int[] answer = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}
