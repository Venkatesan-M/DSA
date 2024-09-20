package SearchingTechniques.Binary;

// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=5701s
public class FindSmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char  target = 'a';
        char output = nextGreatestLetter(letters, target);
        System.out.println(output);
        
    }
    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0; int end = letters.length - 1; 
        while(start <= end){
            int mid = start + (end - start) /2 ;
            if(target < letters[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
