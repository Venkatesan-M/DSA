package DataStructures.Graphs.Algorithms.Path;

import java.util.*;

public class TravellingSalesMan {
    public static void main(String[] args) {
    }


    // https://www.geeksforgeeks.org/problems/travelling-salesman-problem2732/1

    int n;
    int[][] dp;

    public int tsp(int[][] cost) {
        n = cost.length;
        dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return travel(cost, 1, 0);
    }

    int travel(int[][] cost, int mask, int pos) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int minCost = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = cost[pos][city] + travel(cost, mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }

        return dp[mask][pos] = minCost;
    }
}