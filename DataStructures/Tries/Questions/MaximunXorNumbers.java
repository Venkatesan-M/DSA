package DataStructures.Tries.Questions;

import java.util.Arrays;

public class MaximunXorNumbers {
    
    class Trie {
        private class Node {
            Node[] links = new Node[2];
            void set(int i, Node node){ links[i] = node; }
            Node get(int i){ return links[i]; }
            boolean containsKey(int i){ return links[i] != null; }
        }
        private Node root = new Node();

        void insert(int num){
            Node node = root;
            for (int i = 31; i >= 0; i--){
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)){
                    node.set(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int getMax(int x){
            Node node = root;
            int ans = 0;
            for (int i = 31; i >= 0; i--){
                int bit = (x >> i) & 1;
                int want = 1 - bit;
                if (node.containsKey(want)){
                    ans |= (1 << i);
                    node = node.get(want);
                } else {
                    node = node.get(bit);
                }
            }
            return ans; // this is the XOR result
        }
    }

    // https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) trie.insert(num);
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, trie.getMax(num));
        }
        return max;
    }



    // https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[][] offline = new int[n][3];

        // store query as [xi, ai, original_index]
        for(int i = 0; i < n; i++){
            offline[i] = new int[]{queries[i][0], queries[i][1], i};
        }

        // sort queries by ai
        Arrays.sort(offline, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(nums);

        Trie trie = new Trie();
        int[] ans = new int[n];
        int p = 0, m = nums.length;

        for(int[] q : offline){
            int xi = q[0], ai = q[1], idx = q[2];

            // insert all nums <= ai
            while(p < m && nums[p] <= ai){
                trie.insert(nums[p]);
                p++;
            }

            // if no elements inserted, answer is -1
            if (p == 0) ans[idx] = -1;
            else ans[idx] = trie.getMax(xi);
        }

        return ans;
    }
}
