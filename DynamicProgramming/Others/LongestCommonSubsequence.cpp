#include <iostream>
#include <vector>
#include <string>
#include <algorithm>  // Needed for reverse()

using namespace std;

// Define the longestCommonSubsequence function before calling it
int longestCommonSubsequence(string text1, string text2) {
    int m = text1.length();
    int n = text2.length();
    
    // Create a dp table initialized with 0s
    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

    // Fill the dp table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Backtrack to find the LCS string
    int i = m, j = n;
    string res = "";
    while (i > 0 && j > 0) {
        if (text1[i - 1] == text2[j - 1]) {
            res += text1[i - 1];  // Append the matching character
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;  // Move upwards
        } else {
            j--;  // Move leftwards
        }
    }

    reverse(res.begin(), res.end());  // Reverse to get the correct order
    cout << "Longest Common Subsequence: " << res << endl;

    return dp[m][n];  // Return the length of LCS
}

int main() {
    string text1 = "abcde";
    string text2 = "ace";
    
    // Call the LCS function and print the length
    int n = longestCommonSubsequence(text1, text2);
    cout << "Length of Longest Common Subsequence: " << n << endl;
    
    return 0;
}
