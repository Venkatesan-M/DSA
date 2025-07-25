package DynamicProgramming.Grids;

import java.util.Stack;

public class MaximumArea {

    // https://leetcode.com/problems/maximal-rectangle/description/
    // This problem is a variation of Largest Rectangle in Histogram
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            // Update the height array
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            // Apply Largest Rectangle in Histogram
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }

    // Standard Largest Rectangle in Histogram using stack
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Fill left
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();

        // Fill right
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        // Calculate area
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
        }

        return maxArea;
    }

}