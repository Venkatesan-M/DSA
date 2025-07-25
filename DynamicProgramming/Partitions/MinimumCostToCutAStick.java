
package DynamicProgramming.Partitions;

import java.util.Arrays;
import java.util.List;

public class MinimumCostToCutAStick {
    
    // https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
    public int minCost(int n, int[] cuts) {
        // List<Integer> stick = new ArrayList<>();
        // stick.add(0);
        // for (int i : cuts) stick.add(i);
        // stick.add(n);
        // Collections.sort(stick);

        // int size = stick.size();
        // int[][] memo = new int[size][size];
        // for (int[] row : memo) Arrays.fill(row, -1);

        // return cut(stick, 1, size - 2, memo);

        int m = cuts.length;
        int[] allCuts = new int[m + 2];
        System.arraycopy(cuts, 0, allCuts, 1, m);
        allCuts[0] = 0;
        allCuts[m + 1] = n;
        Arrays.sort(allCuts);

        int[][] dp = new int[m + 2][m + 2];

        // len is the segment size between i and j
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }

    int cut(List<Integer> stick, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = stick.get(j + 1) - stick.get(i - 1);
            cost += cut(stick, i, k - 1, memo) + cut(stick, k + 1, j, memo);
            min = Math.min(min, cost);
        }

        memo[i][j] = min;
        return min;
    }
}