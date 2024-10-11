#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Function to check if placing a queen at board[row][col] is safe
bool isSafe(int row, int col, char** board, int n) {
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
void solve(int col, char** board, int n, char*** res, int* returnSize, int* returnColumnSizes) {
    // Base case: If all queens are placed
    if (col == n) {
        // Allocate memory for the current solution
        res[*returnSize] = (char**)malloc(n * sizeof(char*));
        for (int i = 0; i < n; i++) {
            res[*returnSize][i] = (char*)malloc((n + 1) * sizeof(char));
            strcpy(res[*returnSize][i], board[i]); // Copy the board row to the solution
        }

        // Record the column size for this solution
        returnColumnSizes[*returnSize] = n;
        (*returnSize)++; // Increment the solution count
        return;
    }

    // Try placing a queen in each row of the current column
    for (int row = 0; row < n; row++) {
        if (isSafe(row, col, board, n)) {
            board[row][col] = 'Q'; // Place the queen
            solve(col + 1, board, n, res, returnSize, returnColumnSizes); // Recur to place the next queen
            board[row][col] = '.'; // Backtrack: Remove the queen
        }
    }
}

// Main function to solve the N-Queens problem and return all solutions
char*** solveNQueens(int n, int* returnSize, int** returnColumnSizes) {
    // Initialize the board
    char** board = (char**)malloc(n * sizeof(char*));
    for (int i = 0; i < n; i++) {
        board[i] = (char*)malloc((n + 1) * sizeof(char)); // Each row has n characters + 1 for the null terminator
        for (int j = 0; j < n; j++) {
            board[i][j] = '.'; // Initialize the board with empty spots
        }
        board[i][n] = '\0'; // Null terminate the row string
    }

    // Prepare the return values
    char*** res = (char***)malloc(500 * sizeof(char**)); // Allocate space for up to 500 solutions (adjustable)
    *returnSize = 0; // Initialize the number of solutions found
    *returnColumnSizes = (int*)malloc(500 * sizeof(int)); // Allocate memory for the sizes of each solution

    // Start solving
    solve(0, board, n, res, returnSize, *returnColumnSizes);

    // Free the board
    for (int i = 0; i < n; i++) {
        free(board[i]);
    }
    free(board);

    // Return the list of solutions
    return res;
}

// Example usage:
int main() {
    int n = 4; // For example, let's solve for a 4x4 board
    int returnSize;
    int* returnColumnSizes;

    // Get the solutions
    char*** solutions = solveNQueens(n, &returnSize, &returnColumnSizes);

    // Print the solutions
    printf("Number of solutions: %d\n\n", returnSize);
    for (int i = 0; i < returnSize; i++) {
        printf("Solution %d:\n", i + 1);
        for (int j = 0; j < returnColumnSizes[i]; j++) {
            printf("%s\n", solutions[i][j]);
        }
        printf("\n");
    }

    // Free the memory allocated for the solutions
    for (int i = 0; i < returnSize; i++) {
        for (int j = 0; j < returnColumnSizes[i]; j++) {
            free(solutions[i][j]);
        }
        free(solutions[i]);
    }
    free(solutions);
    free(returnColumnSizes);

    return 0;
}
