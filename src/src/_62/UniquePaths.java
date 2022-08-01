package _62;

public class UniquePaths {

    private int solve(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        long answer = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){
            answer *= i;
            answer /= j;
        }

        return (int)answer;
    }

    public void driver() {
        int m = 3;
        int n = 7;
        int answer = this.solve(m, n);
        System.out.println(answer);
    }

}
