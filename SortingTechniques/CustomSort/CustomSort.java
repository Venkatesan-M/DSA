package SortingTechniques.CustomSort;

import java.util.*;

// Demonstrates different ways to implement custom sorting in Java
public class CustomSort {

    // 1. Using a separate Comparator class
    private static class YourWay implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            // Sort by first element, then second, then third
            if (a[0] != b[0]) return a[0] - b[0]; // a[0] < b[0] should be met, else swap
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        }
    }

    public static void main(String[] args) {
        List<int[]> temp = new ArrayList<>();
        temp.add(new int[]{1, 2, 3});
        temp.add(new int[]{1, 2, 4});
        temp.add(new int[]{1, 3, 5});
        temp.add(new int[]{2, 2, 4});
        temp.add(new int[]{3, 3, 5});

        // 1. Sort using separate Comparator class
        Collections.sort(temp, new YourWay());

        // 2. Sort using anonymous class
        Collections.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            }
        });

        // 3. Sort using lambda expression (Java 8+)
        temp.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int[] t : temp) {
            System.out.print(Arrays.toString(t) + ", ");
        }
    }
}
