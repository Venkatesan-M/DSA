package DynamicProgramming.Others;

import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    
    // Pascal's Triangle
    //     1 
    //    1 1
    //   1 2 1
    //  1 3 3 1
    // 1 4 6 4 1

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = generate(n);
        System.out.println(ans);

        List<Integer> row = getRow(n);

        System.out.println(row);
    }
    
    // Easy
    // https://leetcode.com/problems/pascals-triangle/description/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            if (i < 2){
                int k = i + 1;
                while(k > 0){
                    temp.add(1);
                    k--;
                }
                ans.add(temp);
            }
            else{
                temp.add(1);
                List<Integer> prev = ans.get(i - 1);
                for( int k = 0; k < prev.size() - 1; k++){
                    temp.add(prev.get(k) + prev.get(k+1));
                }
                temp.add(1);
                ans.add(temp);
            }
        }
        return ans;
    }

    // Easy
    // https://leetcode.com/problems/pascals-triangle-ii/description/
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++){
            List<Integer> temp = new ArrayList<>();
            if (i < 2){
                int k = i + 1;
                while(k > 0){
                    temp.add(1);
                    k--;
                }
                ans.add(temp);
            }
            else{
                temp.add(1);
                List<Integer> prev = ans.get(i - 1);
                for( int k = 0; k < prev.size() - 1; k++){
                    temp.add(prev.get(k) + prev.get(k+1));
                }
                temp.add(1);
                ans.add(temp);
            }
        }
        return ans.get(rowIndex);
    }
}
