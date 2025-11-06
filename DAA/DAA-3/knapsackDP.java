public class KnapsackDP {

    // Function to solve 0/1 Knapsack
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1]; // DP table

        // Build table dp[][] bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0; // Base condition
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w]; // Can't include item
            }
        }

        return dp[n][W]; // Max value
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 }; // values (profit)
        int wt[] = { 10, 20, 30 };    // weights
        int W = 50;                   // capacity
        int n = val.length;

        int maxValue = knapSack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
