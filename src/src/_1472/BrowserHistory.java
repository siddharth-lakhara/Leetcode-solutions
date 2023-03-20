package _1472;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    
    private int length = 0;
    private int currIdx = -1;
    private List<String> history; 

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        
        add(homepage);
    }
    
    private void add(String url) {
        history.add(url);
        length++;
        currIdx = length-1;
    }

    public void visit(String url) {
        if (currIdx != length-1) {
            history = history.subList(0, currIdx+1);
            length = currIdx+1;
        }
        
        add(url);
    }

    public String back(int steps) {
        currIdx = Math.max(currIdx - steps, 0);
        return history.get(currIdx);
    }

    public String forward(int steps) {
        currIdx = Math.min(currIdx+steps, length-1);
        return history.get(currIdx);
    }
}
