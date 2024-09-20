package SearchingTechniques.Linear;

// https://youtu.be/_HRA37X8N_Q?si=Td7yUI8pyUHaJkhM
public class EvenDigitNumbers {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int output = findNumbers(nums);
        System.out.println(output);
    }

    // https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    public static int findNumbers(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = 0;
        for(int i = 0; i < nums.length; i++){

            // Using Number theroy; 
            if(((int)Math.log10(nums[i]) + 1)%2==0){
                n++; 
            }

            // Traditional Way of Finding the number of digits
            // int temp = nums[i]; int c = 0;
            // while(temp > 0){
            //     temp = temp / 10;
            //     c++;
            // }
            // if(c%2==0){
            //     n++;
            // }

            // you can use log2 to find the number of digits in binary system;

        }
        return n;
    }
}
