import java.util.Scanner;
import java.util.Arrays;
public class Zombie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line1 = input.nextLine().split(" ");
        String[] line2 = input.nextLine().split(" ");
        int bob = Integer.parseInt(line1[0]);
        int numberOfZombie = Integer.parseInt(line1[1]);
        int[] game = new int[numberOfZombie];
        for(int i = 0; i < numberOfZombie; i++){
            game[i] = Integer.parseInt(line2[i]);
        }

        if(played(bob, numberOfZombie, game)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        input.close();
    }

    static boolean played(int bob, int n, int[] game){
        Arrays.sort(game);
        for(int i = 0; i < n; i++){
            if(game[i] > bob){
                return false;
            }
            bob -= ((game[i]%2) + (game[i]/2));
        }
        return true;
    }
}
