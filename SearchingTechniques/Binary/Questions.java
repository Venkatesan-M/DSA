package SearchingTechniques.Binary;

public class Questions {
    public static void main(String[] args) {
        
    }

    // Medium
    // https://leetcode.com/problems/koko-eating-bananas/description/
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int start = 1, end = maxPile;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (timeTaken(piles, mid) <= (long) h) {
                end = mid - 1; // try to minimize the speed
            } else {
                start = mid + 1; // increase the speed
            }
        }
        return start;
    }
    
    private long timeTaken(int[] piles, int k) {
        long time = 0;
        for (int pile : piles) {
            time += (pile + k - 1L) / k;
        }
        return time;
    }
}
