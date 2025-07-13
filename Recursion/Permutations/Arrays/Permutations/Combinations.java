package Arrays.Permutations;

import java.util.*;

public class Combinations{
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }

    // Medium
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans = findCombinations("", digits);
        return ans;
    }
    public static List<String> findCombinations(String p, String up){
	    List<String> ans = new ArrayList<>();
	    if(up.length() == 0){
	        ans.add(p);
	        return ans;
	    }
	    char ch = up.charAt(0);
        int d = ch - '2'; int s = (d < 6) ? d * 3: d * 3 + 1;
        for(int i = 0; i < 3; i++){
            ans.addAll(findCombinations(p + Character.toString((char)('a' + s + i)), up.substring(1)));
        }
        if(d == 5 || d == 7){
            ans.addAll(findCombinations(p + Character.toString((char)('a' + s + 3)), up.substring(1)));
        }
	    return ans;
	}
    // // brute force hard coded approach.
    // public static List<String> findCombinations(String p, String up){
	//     List<String> ans = new ArrayList<>();
	//     if(up.length() == 0){
	//         ans.add(p);
	//         return ans;
	//     }
	//     char ch = up.charAt(0);
	//     if(ch == '2'){
	//         ans.addAll(findCombinations(p + "a", up.substring(1)));
	//         ans.addAll(findCombinations(p + "b", up.substring(1)));
	//         ans.addAll(findCombinations(p + "c", up.substring(1)));
	//     }
	//     else if(ch == '3'){
	//         ans.addAll(findCombinations(p + "d", up.substring(1)));
	//         ans.addAll(findCombinations(p + "e", up.substring(1)));
	//         ans.addAll(findCombinations(p + "f", up.substring(1)));
	//     }
	//     else if(ch == '4'){
	//         ans.addAll(findCombinations(p + "g", up.substring(1)));
	//         ans.addAll(findCombinations(p + "h", up.substring(1)));
	//         ans.addAll(findCombinations(p + "i", up.substring(1)));
	//     }
	//     else if(ch == '5'){
	//         ans.addAll(findCombinations(p + "j", up.substring(1)));
	//         ans.addAll(findCombinations(p + "k", up.substring(1)));
	//         ans.addAll(findCombinations(p + "l", up.substring(1)));
	//     }
	//     else if(ch == '6'){
	//         ans.addAll(findCombinations(p + "m", up.substring(1)));
	//         ans.addAll(findCombinations(p + "n", up.substring(1)));
	//         ans.addAll(findCombinations(p + "o", up.substring(1)));
	//     }
	//     else if(ch == '7'){
	//         ans.addAll(findCombinations(p + "p", up.substring(1)));
	//         ans.addAll(findCombinations(p + "q", up.substring(1)));
	//         ans.addAll(findCombinations(p + "r", up.substring(1)));
	//         ans.addAll(findCombinations(p + "s", up.substring(1)));
	//     }
	//     else if(ch == '8'){
	//         ans.addAll(findCombinations(p + "t", up.substring(1)));
	//         ans.addAll(findCombinations(p + "u", up.substring(1)));
	//         ans.addAll(findCombinations(p + "v", up.substring(1)));
	//     }
	//     else if(ch == '9'){
	//         ans.addAll(findCombinations(p + "w", up.substring(1)));
	//         ans.addAll(findCombinations(p + "x", up.substring(1)));
	//         ans.addAll(findCombinations(p + "y", up.substring(1)));
	//         ans.addAll(findCombinations(p + "z", up.substring(1)));
	//     }
	//     return ans;
	// }
}