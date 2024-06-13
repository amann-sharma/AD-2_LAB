public class MatrixChainMultiplication {
    public static int matrixChainMultiplication(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] p = {10, 20, 30, 40, 30};
        int minCost = matrixChainMultiplication(p);
        System.out.println("Minimum cost of matrix chain multiplication: " + minCost);
    }
}
