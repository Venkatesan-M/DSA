package Strings.SubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        String s = "abc";
        List<String> set = subSets(s, 0, "", new ArrayList<>());
        System.out.println(set);
        int[] arr = {1, 2, 3};
        List<List<String>> set1 = subSetInt(arr);
        System.out.println(set1);
        int arr1[] = {1, 2, 2};
        List<List<String>> set2 = subSetIntDuplicates(arr1);
        System.out.println(set2);
    }

    public static List<String> subSets(String s, int i, String ans, List<String> set) {
        // Base case: if we have processed all characters
        if (i == s.length()) {
            set.add(ans); // Add the constructed subset to the set
            return set;
        }

        // Recursive case: include the current character
        subSets(s, i + 1, ans + s.charAt(i), set);

        // Recursive case: exclude the current character
        subSets(s, i + 1, ans, set);

        return set;
    }

    public static List<List<String>> subSetInt(int arr[]) {
        List<List<String>> set = new ArrayList<>();
        set.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            int n = set.size();
            for (int j = 0; j < n; j++) {
                List<String> temp = new ArrayList<>(set.get(j));
                temp.add(String.valueOf(arr[i]));
                set.add(temp);
            }
        }
        return set;
    }

    
    public static List<List<String>> subSetIntDuplicates(int arr[]) {
        Arrays.sort(arr);
        List<List<String>> set = new ArrayList<>();
        int start = 0; int end = 0;
        set.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = set.size() - 1;
            int n = set.size();
            for (int j = start; j < n; j++) {
                List<String> temp = new ArrayList<>(set.get(j));
                temp.add(String.valueOf(arr[i]));
                set.add(temp);
            }
        }
        return set;
    }
}
