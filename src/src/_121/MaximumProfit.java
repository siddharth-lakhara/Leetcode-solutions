package _121;

public class MaximumProfit {

    private int solve(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfitSoFar = 0;
        for (int p : prices) {
            if (p < minSoFar) {
                minSoFar = p;
            } else {
                maxProfitSoFar = Integer.max(maxProfitSoFar, p-minSoFar);
            }
        }
        return maxProfitSoFar;
    }

    public void driver() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int answer = this.solve(prices);
        System.out.println(answer);
    }

}
