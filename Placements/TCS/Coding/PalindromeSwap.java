public class PalindromeSwap {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(isPalindrome(s));
    }
    static boolean isPalindrome(String s){
        int l = s.length(); int misMatch = 0;
        int[] index = new int[2];
        for(int i = 0; i < l/2; i++){
            if(s.charAt(i) != s.charAt(l-i-1)){
                if(misMatch < 2) index[misMatch] = i;
                misMatch++;
            }
        }
        char[] arr = s.toCharArray();
        char temp = arr[index[0]];
        arr[index[0]] = arr[index[1]];
        arr[index[1]] = temp;
        StringBuilder sb = new StringBuilder();
        for(char ch : arr){
            sb.append(ch);
        }
        System.out.println(sb.toString());
        return misMatch == 0 || misMatch == 2;
    }
}
