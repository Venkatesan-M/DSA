import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(!isAlphabet(ch)){
                sb.append(ch);
            }
        }
        System.out.println(Integer.parseInt(sb.toString()));
        input.close();
    }

    static boolean isAlphabet(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
