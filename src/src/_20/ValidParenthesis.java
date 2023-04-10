package _20;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                st.push(p);
            } else {
                if (st.size() == 0) {
                    return false;
                }
                switch (p) {
                    case ')':
                        if (st.pop() != '(') {
                            return false;
                        } 
                        break;
                    case '}':
                        if (st.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (st.pop() != '[') {
                            return false;
                        }
                        break;
                }
            }
        }
        
        return st.size() == 0;
    }
    
    public void driver() {
        String s = "(]";
        boolean answer = isValid(s);
        System.out.println(answer);
    }

}
