/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    const isSafe = (row, col, board) => {
        for (let i = 0; i < col; i++) {
            if (board[row][i] === 'Q') return false;
        }
        for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] === 'Q') return false;
        }
        for (let i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] === 'Q') return false;
        }
        return true;
    };

    const solve = (col, board, ans) => {
        if (col === n) {
            ans.push(board.map(row => row.join('')));
            return;
        }
        for (let row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    };

    const ans = [];
    const board = Array(n).fill().map(() => Array(n).fill('.'));
    solve(0, board, ans);
    return ans;
};

// Test cases
function runTestCases() {
    const testCases = [1, 4, 5];
    
    testCases.forEach(n => {
        console.log(`Test case for n = ${n}:`);
        const solutions = solveNQueens(n);
        console.log(`Number of solutions: ${solutions.length}`);
        
        if (solutions.length > 0) {
            console.log("First solution:");
            solutions[0].forEach(row => console.log(row));
        }
        
        console.log("\n");
    });
}

// Run the test cases
runTestCases();