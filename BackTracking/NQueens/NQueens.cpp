#include <iostream>
#include <vector>
#include <string> // Include string for string manipulations

using namespace std;

// Function to check if placing a queen at board[row][col] is safe
bool isSafe(int row, int col, vector<string> &board, int n) {
    // Check the left side in the same row
    for (int i = col; i >= 0; i--) {
        if (board[row][i] == 'Q') {
            return false;
        }
    }

    // Check upper-left diagonal
    int i = row, j = col;
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 'Q') {
            return false;
        }
        i--; j--;
    }

    // Check lower-left diagonal
    int p = row, q = col;
    while (p < n && q >= 0) {
        if (board[p][q] == 'Q') {
            return false;
        }
        p++; q--;
    }

    return true;
}

// Backtracking function to solve the N-Queens problem
void solve(int col, vector<string> &board, vector<vector<string>> &ans, int n) {
    // Base case: If all queens are placed
    if (col == n) {
        ans.push_back(board); // Add a valid board configuration to the answer
        return;
    }

    // Try placing a queen in each row of the current column
    for (int row = 0; row < n; row++) {
        if (isSafe(row, col, board, n)) {
            board[row][col] = 'Q'; // Place the queen
            solve(col + 1, board, ans, n); // Recur to place the next queen
            board[row][col] = '.'; // Backtrack: Remove the queen
        }
    }
}

// Main function to initialize the board and start solving
vector<vector<string>> solveNQueens(int n) {
    vector<vector<string>> ans; // To store all the valid solutions
    vector<string> board(n, string(n, '.')); // Create an n x n board filled with '.'

    solve(0, board, ans, n); // Start solving from the first column
    return ans; // Return the list of solutions
}

int main() {
    int n;
    cout << "Enter the value of n: ";
    cin >> n; // Input for the size of the board

    vector<vector<string>> solutions = solveNQueens(n); // Solve the N-Queens problem

    // Print all the solutions
    for (const auto &solution : solutions) {
        for (const auto &row : solution) {
            cout << row << endl; // Print each row of the solution
        }
        cout << endl; // Print a new line between different solutions
    }

    return 0; // Return success
}
