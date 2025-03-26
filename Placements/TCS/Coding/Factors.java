import java.util.*;

public class Factors {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 16;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0){
                map.putIfAbsent( i , n / i);
                map.putIfAbsent( n / i , i);
            }
        }
        for(int i : map.keySet()){
            System.out.println(i + " * " + map.get(i));
        }
    }
}
