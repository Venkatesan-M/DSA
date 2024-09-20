package SearchingTechniques.Linear;

public class Examples {
    public static void main(String args[]){
        // Scanner input = new Scanner(System.in);
        // int n = input.nextInt();
        // System.out.println(n);
        // input.close();
        String text = "Hello world";
        char letter = 'a';
        boolean ans = searchString(text, letter);
        System.out.println(ans);
    }

    // https://youtu.be/_HRA37X8N_Q?si=Td7yUI8pyUHaJkhM
    public static boolean searchString(String text, char letter){
        if(text.length() == 0){
            return false;
        }

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == letter){
                return true;
            }
        }

        return false;
    }

    public static boolean searchString1(String text, char letter){
        if(text.length() == 0){
            return false;
        }

        for(char ch : text.toCharArray()){
            if(ch == letter){
                return true;
            }
        }

        return false;
    }
    
}
