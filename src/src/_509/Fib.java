package _509;

public class Fib {
    private int solve(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solve(n-1) + solve(n-2);
    }

    public void driver() {
        int n = 5;
        int answer = solve(n);
        System.out.println(answer);
    }
}
