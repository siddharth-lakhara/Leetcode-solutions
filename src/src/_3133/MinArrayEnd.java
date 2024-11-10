package _3133;

public class MinArrayEnd {
    public long minEnd(int n, int x) {
        long answer = x;
        n--;
        while (n>0) {
            answer++;
            answer|=x;
            n--;
        }
        return answer;
    }

    public void driver() {
        int n=3,x=4;

        long answer = minEnd(n, x);
        System.out.println(answer);
    }
}
