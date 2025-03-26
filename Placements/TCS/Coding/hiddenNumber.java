import java.util.*;

public class hiddenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // String s = input.nextLine();
        String s = "D@h*o1n8i%";
        System.out.println(find(s));
        input.close();
    }
    
    static int find(String s){
        int sum = 0;
        for(char ch : s.toCharArray()){
            if(ch - 'a' >= 0 && ch - 'a' <= 25){
                sum += ch - 'a' + 1;
            }
            if(ch - 'A' >= 0 && ch - 'A' <= 25){
                sum += ch - 'A' + 1;
            }
        }
        int n = 0;
        while(sum > 0){
            n += sum % 10;
            sum = sum / 10;
        }
        return n;
    }
}