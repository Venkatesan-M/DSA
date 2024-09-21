package SearchingTechniques.Binary;

interface MountainArray {
     public int get(int index);
     public int length();
}

class MockMountainArray implements MountainArray {
    private int[] arr;

    public MockMountainArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

public class MountainArraySearch {
    public static void main(String[] args) {
        MountainArray mountainArray = new MockMountainArray(new int[]{1, 5, 2});
        MountainArraySearch search = new MountainArraySearch();
        int target = 1;
        
        // Find the target in the mountain array
        int result = search.findInMountainArray(target, mountainArray);
        
        System.out.println("Output: " + result);
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        // First, find the peak element
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                // You're in the descending part of the array
                // This could be the peak, but look left
                end = mid;
            } else {
                // You're in the ascending part of the array
                start = mid + 1;
            }
        }

        // At the end of the while loop, start == end, which points to the peak element
        int peak = start;

        // Try to find the target in the ascending part
        int result = orderAgnosticBinarySearch(target, mountainArr, 0, peak);
        if (result != -1) {
            return result;  // Target found in the ascending part
        }

        // Try to find the target in the descending part
        return orderAgnosticBinarySearch(target, mountainArr, peak + 1, mountainArr.length() - 1);
    }

    public static int orderAgnosticBinarySearch(int target, MountainArray mountainArr, int start, int end) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);  // Determine if the subarray is ascending or descending

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);

            if (target == midElement) {
                return mid;  // Target found
            }

            if (isAsc) {  // Ascending order
                if (target < midElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {  // Descending order
                if (target > midElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;  // Target not found
    }
}
