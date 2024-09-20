package SearchingTechniques.Linear;

// https://youtu.be/_HRA37X8N_Q?si=Td7yUI8pyUHaJkhM
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        int output = maximumWealth(accounts);
        System.out.println(output);
        
    }

    // https://leetcode.com/problems/richest-customer-wealth/description/
    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] arr : accounts){
            int temp = 0;
            for(int n: arr){
                temp+=n;
            }
            if(temp>max){
                max = temp;
            }
        }
        return max;
    }
}
