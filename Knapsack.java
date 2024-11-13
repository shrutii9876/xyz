public class Knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 4, 6, 5 };
        int[] profit = { 2, 3, 1, 4 };
        int capacity = 8;
        int ans = getMaxProfit(weight, profit, capacity);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] weight, int[] profit, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity+1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + profit[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][capacity];
    }
}