#include <iostream>
#include <vector>
#include <climits> // For INT_MAX

using namespace std;

void printPara(vector<vector<int>> &s, int i, int j) {
    if (i == j) {
        cout << "A" << i;
    } else {
        cout << "(";
        printPara(s, i, s[i][j]);
        printPara(s, s[i][j] + 1, j);
        cout << ")";
    }
}

int matrixChainMultiplication(vector<int> &p, int n) {
    vector<vector<int>> m(n, vector<int>(n, 0)); // DP table for costs
    vector<vector<int>> s(n, vector<int>(n, 0)); // DP table for splits

    for (int l = 2; l < n; l++) { // l is the chain length
        for (int i = 1; i < n - l + 1; i++) {
            int j = i + l - 1;
            m[i][j] = INT_MAX;
            for (int k = i; k < j; k++) {
                // Calculate the cost of multiplying Ai...Ak and Ak+1...Aj
                int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k; // Record the split point
                }
            }
        }
    }

    cout << "Optimal Parenthesization: ";
    printPara(s, 1, n - 1); // Print the optimal order
    cout << endl;

    return m[1][n - 1]; // Return the minimum cost
}

int main() {
    vector<int> p = {30, 35, 15, 5, 10, 20, 25}; // Example dimensions
    int n = p.size();

    int minCost = matrixChainMultiplication(p, n);
    cout << "Minimum number of multiplications: " << minCost << endl;

    return 0;
}
