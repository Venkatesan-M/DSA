package SlidingWindow;

public class questions {
    public static void main(String[] args) {
        
    }

    // Easy
    // https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
    public int minimumRecolors(String blocks, int k) {
        // Brute Force takes O(n*k) and O(k) // two for loops
        // to optimise we will use sliding window O(N) and O(1)
        int n = blocks.length();
        int white = 0;
        int L = 0; int R = 0;
        // find the number of whites in the window (Pre compute)
        while(R < k){
            if(blocks.charAt(R) == 'W')
                white++;
            R++;
        }
        int ans = white;
        // move left and right while removing and adding character
        while(R < n){
            if(blocks.charAt(L) == 'W')
                white--;
            if(blocks.charAt(R) == 'W')
                white++;
            ans = Math.min(ans, white);
            L++; R++;
        }
        return ans;
    }

    // Medium
    // https://leetcode.com/problems/alternating-groups-ii/description/
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0; int n = colors.length;
        int l = 0;
        for(int r = 1; r < n + k - 1; r++){
            if(colors[(r-1)%n] == colors[r%n]){
                l = r;
            }
            if(r - l + 1 == k){
                ans++;
                l++;
            }
        }
        return ans;
    }
}
