package _150;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateRPN {
    final ArrayList<String> operations = new ArrayList<>() {
        {
            add("+");
            add("-");
            add("*");
            add("/");
        }
    };

    private int solve(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String tok : tokens) {
            if (operations.contains(tok)) {
                int n2 = st.pop();
                int n1 = st.pop();
                int result;
                if (tok.equals("+")) {
                    result = n1 + n2;
                } else if (tok.equals("-")) {
                    result = n1 - n2;
                } else if (tok.equals("*")) {
                    result = n1 * n2;
                } else {
                    result = n1 / n2;
                }
                st.push(result);
            } else {
                st.push(Integer.valueOf(tok));
            }
        }
        return st.pop();
    }

    public void driver() {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int answer = this.solve(tokens);
        System.out.println(answer);
    }

}
