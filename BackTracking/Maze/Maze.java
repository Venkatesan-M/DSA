package BackTracking.Maze;

import java.util.*;

public class Maze{
    public static void main(String[] args) {
        // System.out.println(countPaths(3, 3));
        // printPaths("", 3, 3);
        // List<String> ans = returnPaths("", 3, 3);
        // System.out.println(ans);

        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true},
        };
        List<String> sol = restrictedPaths("", maze, 0, 0);
        System.out.println(sol);

        boolean[][] isVisited = {
            {false, false, false},
            {false, false, false},
            {false, false, false},
        };
        System.out.println(travelOncePaths("", isVisited, 0, 0));
        char[][] game = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', 'G'},
        };
        // mazePaths(isVisited, game, 0, 0);
        mazePathsNumbered(isVisited, game, -1, 0, 0);
    }

    //     Maze 
    //    3  2  1
    // 3 [S, -, -]
    // 2 [-, -, -]
    // 1 [-, -, G]
    //
    // either you can go right or down to reach from start to goal

    static int countPaths(int r, int c){
        if(r == 1){
            return 1;
        }
        if(c == 1){
            return 1;
        }
        int right = countPaths(r, c - 1);
        int down = countPaths(r - 1, c);
        return right + down;
    }   

    static void printPaths(String path, int r, int c){
        if(r == 1 && c == 1){
            // Goal is reached 
            System.out.println(path);
            return;
        }
        if(c > 1){
            // Traverse right only if it possible
            printPaths(path + "R", r, c - 1);
        }
        if(r > 1){
            // Traverse Down only if it possible
            printPaths(path + "D", r - 1, c);
        }
    }

    static List<String> returnPaths(String path, int r, int c){
        List<String> ans = new ArrayList<>();
        if(r == 1 && c == 1){
            ans.add(path);
            return ans;
        }
        if(c > 1){
            ans.addAll(returnPaths(path + "R", r, c - 1));
        }
        if(r > 1){
            ans.addAll(returnPaths(path + "D", r - 1, c));
        }
        return ans;
    }

    //     Maze 
    //    3  2  1
    // 3 [S, -, -]
    // 2 [-, O, -]
    // 1 [-, -, G]
    //
    // either you can go right or down to reach from start to goal you can't go to obstacle

    static List<String> restrictedPaths(String path, boolean[][] maze, int r, int c){
        List<String> ans = new ArrayList<>();
        if(r == maze.length - 1 && c == maze[0].length - 1){
            ans.add(path);
            return ans;
        }
        if(c < maze[0].length - 1 && maze[r][c+1]){
            // making sure there is no obstacle
            ans.addAll(restrictedPaths(path + "R", maze, r, c + 1));
        }
        if(r < maze.length - 1 && maze[r+1][c]){
            ans.addAll(restrictedPaths(path + "D", maze, r + 1, c));
        }
        return ans;
    }

    public static List<String> travelOncePaths(String path, boolean[][] isVisited, int r, int c) {
        List<String> ans = new ArrayList<>();
        if (r == isVisited.length - 1 && c == isVisited[0].length - 1) {
            ans.add(path);
            return ans;
        }

        // Mark the current cell as visited
        isVisited[r][c] = true;

        // Move Right
        if (c < isVisited[0].length - 1 && !isVisited[r][c + 1]) {
            ans.addAll(travelOncePaths(path + "R", isVisited, r, c + 1));
        }

        // Move Down
        if (r < isVisited.length - 1 && !isVisited[r + 1][c]) {
            ans.addAll(travelOncePaths(path + "D", isVisited, r + 1, c));
        }

        // Move Left
        if (c > 0 && !isVisited[r][c - 1]) {
            ans.addAll(travelOncePaths(path + "L", isVisited, r, c - 1));
        }

        // Move Up
        if (r > 0 && !isVisited[r - 1][c]) {
            ans.addAll(travelOncePaths(path + "U", isVisited, r - 1, c));
        }

        // Backtrack: unmark the current cell
        isVisited[r][c] = false;

        return ans;
    }

    static void mazePaths(boolean[][] isVisited, char[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            for(char[] arr : maze){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        isVisited[r][c] = true;
        if(r < maze.length - 1 && !isVisited[r+1][c]){
            maze[r][c] = 'v';
            mazePaths(isVisited, maze, r + 1, c);
            maze[r][c] = ' '; // clear the board for right recursion call 
        }
        if(c < maze[0].length - 1 && !isVisited[r][c+1]){
            maze[r][c] = '>';
            mazePaths(isVisited, maze, r, c + 1);
            maze[r][c] = ' '; // backtracking step
        }
        if(r > 0 && !isVisited[r - 1][c]){
            maze[r][c] = '^';
            mazePaths(isVisited, maze, r - 1, c);
            maze[r][c] = ' ';
        }
        if(c > 0 && !isVisited[r][c-1]){
            maze[r][c] = '<';
            mazePaths(isVisited, maze, r, c - 1);
            maze[r][c] = ' ';
        }
        isVisited[r][c] = false;
    }
    static void mazePathsNumbered(boolean[][] isVisited, char[][] maze, int lvl, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            for(char[] arr : maze){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        // changes made in the recursion function body 
        isVisited[r][c] = true; lvl++; maze[r][c] = (char)('0' + lvl);
        if(r < maze.length - 1 && !isVisited[r+1][c]){
            mazePathsNumbered(isVisited, maze, lvl, r + 1, c);
        }
        if(c < maze[0].length - 1 && !isVisited[r][c+1]){
            mazePathsNumbered(isVisited, maze, lvl, r, c + 1);
        }
        if(r > 0 && !isVisited[r - 1][c]){
            mazePathsNumbered(isVisited, maze, lvl, r - 1, c);
        }
        if(c > 0 && !isVisited[r][c-1]){
            mazePathsNumbered(isVisited, maze, lvl, r, c - 1);
        }
        // undo the changes so that other recursive solution doesn't get affected
        // backtracking part
        isVisited[r][c] = false; lvl--; maze[r][c] = ' ';
    }
}