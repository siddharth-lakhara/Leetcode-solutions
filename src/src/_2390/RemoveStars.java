package _2390;

public class RemoveStars {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder(s);
        
        int maxIterations = s.length();
        for (int i = 0; i < maxIterations; i++) {
            if (builder.charAt(i) == '*') {
                builder.deleteCharAt(i);
                builder.deleteCharAt(i-1);
                i-=2;
                maxIterations-=2;
            }
        }
        
        return builder.toString();
    }

    public void driver() {
//        String s = "leet**cod*e";
        String s = "erase*****";

        String answer = removeStars(s);
        System.out.println(answer);
    }
}
