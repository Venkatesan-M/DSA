package DynamicProgramming.Partitions;

import java.util.HashMap;
import java.util.Map;

public class EvaluateBooleanExpression {
    
    // https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
    static int countWays(String s) {
        Map<String, Integer> memo = new HashMap<>();
        return countWaysUtil(s, 0, s.length() - 1, 1, memo);
    }

    static int countWaysUtil(String s, int i, int j, int isTrue, Map<String, Integer> memo) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }

        String key = i + "_" + j + "_" + isTrue;
        if (memo.containsKey(key)) return memo.get(key);

        int ways = 0;

        for (int idx = i + 1; idx <= j - 1; idx += 2) {
            char op = s.charAt(idx);

            int leftTrue = countWaysUtil(s, i, idx - 1, 1, memo);
            int leftFalse = countWaysUtil(s, i, idx - 1, 0, memo);
            int rightTrue = countWaysUtil(s, idx + 1, j, 1, memo);
            int rightFalse = countWaysUtil(s, idx + 1, j, 0, memo);

            if (op == '&') {
                if (isTrue == 1)
                    ways += (leftTrue * rightTrue);
                else
                    ways += (leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse);
            } else if (op == '|') {
                if (isTrue == 1)
                    ways += (leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue);
                else
                    ways += (leftFalse * rightFalse);
            } else if (op == '^') {
                if (isTrue == 1)
                    ways += (leftTrue * rightFalse + leftFalse * rightTrue);
                else
                    ways += (leftTrue * rightTrue + leftFalse * rightFalse);
            }
        }

        memo.put(key, ways);
        return ways;
    }
}
