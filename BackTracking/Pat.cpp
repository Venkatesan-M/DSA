#include <iostream>
#include <vector>

using namespace std;

bool solve(int start, int disSum, int n, vector<int> &ans) {
    if (disSum == n) {  // If we have reached the sum n
        return true;
    }
    if (disSum > n) {  // If the sum exceeds n, stop further exploration
        return false;
    }

    for (int i = start; i <= n; ++i) {
        if (disSum + i <= n) {  // Only proceed if adding i doesn't exceed n
            ans.push_back(i);   // Choose the current number
            if (solve(i + 1, disSum + i, n, ans)) {
                return true;    // If the solution is found, return true
            }
            ans.pop_back();     // Backtrack
        }
    }
    return false;  // No solution found in this branch
}

vector<int> distinctPositiveNumbers(int n) {
    vector<int> ans;
    solve(1, 0, n, ans);
    return ans;
}

int main() {
    int n;
    cin >> n;
    vector<int> ans = distinctPositiveNumbers(n);

    // Output the result
    for (const auto &num : ans) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
