package Strings.Permutations;

import java.util.*;

public class Permutations{
    public static void main(String[] args) {
        printPermutations("", "abc");
        List<String> sol = permutations("", "abc", new ArrayList<>());
        System.out.println(sol);
        List<String> ans = permutations("", "123");
        System.out.println(ans);
    }

    // p -> Processed, up -> UnProcessed and np -> nextProcess
    static void printPermutations(String p, String up){
        if(up.length() == 0){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0); int n = p.length();
        // n+1 places is left to fill by the new character in the process string
        for(int i = 0; i <= n; i++){
            String f = p.substring(0, i);
            String l = p.substring(i, n);
            String np = f + ch + l;
            printPermutations(np, up.substring(1));
        } 
    }

    // arrays is passed as argument
    static List<String> permutations(String p, String up, List<String> ans){
        if(up.length() == 0){
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0); int n = p.length();
        // n+1 places is left to fill by the new character in the process string
        for(int i = 0; i <= n; i++){
            String f = p.substring(0, i);
            String l = p.substring(i, n);
            String np = f + ch + l;
            permutations(np, up.substring(1), ans);
        } 
        return ans;
    }

    // array is referenced and values are added
    static List<String> permutations(String p, String up){
        List<String> ans = new ArrayList<>();
        if(up.length() == 0){
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0); int n = p.length();
        // n+1 places is left to fill by the new character in the process string
        for(int i = 0; i <= n; i++){
            String f = p.substring(0, i);
            String l = p.substring(i, n);
            String np = f + ch + l;
            ans.addAll(permutations(np, up.substring(1)));
        } 
        return ans;
    }
}