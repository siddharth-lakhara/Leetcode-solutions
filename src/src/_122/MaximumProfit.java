package _122;

public class MaximumProfit {

    private int solve(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += (prices[i] - prices[i-1]);
            }
        }
        return maxProfit;
    }

    public void driver() {
        int[] prices = new int[]{1,2,3,4,5};
        int answer = this.solve(prices);
        System.out.println(answer);
    }

}
