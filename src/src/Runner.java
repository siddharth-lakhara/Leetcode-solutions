import _1472.BrowserHistory;
import _208.Trie;

public class Runner {

    public static void main(String[] args) {
//        ConstructTree solution = new ConstructTree();
//        solution.driver();

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        String ans1 = browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        String ans2 = browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        String ans3 = browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        String ans4 = browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        String ans5 = browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        String ans6 = browserHistory.back(7);

        System.out.println(String.join(", ", ans1, ans2, ans3, ans4, ans5, ans6));
    }
}
