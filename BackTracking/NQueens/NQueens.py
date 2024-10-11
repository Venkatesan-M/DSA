from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def isSafe(row: int, col: int, board: List[str]) -> bool:
            # Check the left side in the same row
            for i in range(col):
                if board[row][i] == 'Q':
                    return False

            # Check upper-left diagonal
            i, j = row, col
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j -= 1

            # Check lower-left diagonal
            i, j = row, col
            while i < n and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i += 1
                j -= 1

            return True

        def solve(col: int, board: List[str], ans: List[List[str]]):
            # Base case: If all queens are placed
            if col == n:
                ans.append(board.copy())  # Add a valid board configuration to the answer
                return

            # Try placing a queen in each row of the current column
            for row in range(n):
                if isSafe(row, col, board):
                    board[row] = board[row][:col] + 'Q' + board[row][col+1:]  # Place the queen
                    solve(col + 1, board, ans)  # Recur to place the next queen
                    board[row] = board[row][:col] + '.' + board[row][col+1:]  # Backtrack: Remove the queen

        ans = []
        board = ['.' * n for _ in range(n)]  # Create an n x n board filled with '.'
        solve(0, board, ans)  # Start solving from the first column
        return ans

# Main function to test the solution
if __name__ == "__main__":
    n = int(input("Enter the value of n: "))
    solution = Solution()
    solutions = solution.solveNQueens(n)

    # Print all the solutions
    for sol in solutions:
        for row in sol:
            print(row)
        print()  # Print a new line between different solutions