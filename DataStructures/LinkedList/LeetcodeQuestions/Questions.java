package DataStructures.LinkedList.LeetcodeQuestions;

import java.util.HashSet;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3};
        ListNode head = createList(arr);
        display(head);

        head = deleteDuplicates(head);
        display(head);
    }
        
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void display(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }   
        
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    // Easy
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate.
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/
    // Easy
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // not the head
        ListNode ptr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        if (list1 != null) {
            ptr.next = list1;
        } else {
            ptr.next = list2;
        }

        return dummy.next; // head
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/
    // Easy
    public ListNode middleNode(ListNode head) {
        // Imagine two person running a race, where the linkedlist is the track;
        // while the fast person finish the race, the slow person will be at midpoint of the track
        // that logic is used to find the mid-point in one single pass
        ListNode fast = head; ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // https://leetcode.com/problems/linked-list-cycle/
    // Easy
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean fastAndSlow(ListNode head) {
        ListNode fast = head; ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public int cycleLength(ListNode head) {
        ListNode fast = head; ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int len = 0;
                do {
                    slow = slow.next;
                    len++;
                } while(slow != fast);
                return len;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii
    // Medium
    public ListNode detectCycle(ListNode head) {
        // 1. calculate the length of the cycle (k) and move second by k
        int len = cycleLength(head);
        if (len == -1) {
            return null; // If no cycle, return null
        }

        ListNode first = head, second = head;

        // Move second pointer `len` steps ahead
        while (len > 0) {
            second = second.next;
            len--;
        }

        // Move both pointers at the same pace until they meet at the cycle start
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    // https://leetcode.com/problems/happy-number/
    // Easy
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = getDigitSqSum(slow);
            fast = getDigitSqSum(getDigitSqSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    static int getDigitSqSum(int n){
        int res = 0;
        while(n > 0){
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }

    // https://leetcode.com/problems/sort-list/
    // Medium
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = middleNode(head);
        ListNode node = head; ListNode temp = node;
        while(temp.next != middle){
            temp = temp.next;
        }
        temp.next = null;
        ListNode left = sortList(node);
        ListNode right = sortList(middle);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                ptr.next = left;
                left = left.next;
            }else{
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }
        while(left != null){
            ptr.next = left;
            left = left.next;
            ptr = ptr.next;
        }
        while(right != null){
            ptr.next = right;
            right = right.next;
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public ListNode BubblesortList(ListNode head) {
        int l = LLL(head);
        for(int i = 0; i < l; i++){
            ListNode temp = head;
            boolean isSorted = true;
            for(int j = 0; j < l - i - 1; j++){
                if(temp.val > temp.next.val){
                    int t = temp.next.val;
                    temp.next.val = temp.val;
                    temp.val = t;
                    isSorted = false;
                }
                temp = temp.next;
            }
            if(isSorted){
                break;
            }
        }
        return head;
    }

    int LLL(ListNode head){
        ListNode node = head;
        int l = 0;
        while(node != null){
            node = node.next; l++;
        }
        return l;
    }

    // https://leetcode.com/problems/reverse-linked-list/
    // Easy
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // https://leetcode.com/problems/reverse-linked-list-ii/
    // Medium
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Reach the left position
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode LP = dummy;
        for (int i = 1; i < left; i++) {
            LP = LP.next;
        }

        // Step 2: Identify the sublist that needs to be reversed
        ListNode L = LP.next;
        ListNode R = L;
        for (int i = left; i < right; i++) {
            R = R.next;
        }
        ListNode RN = R.next; // Node after right position

        // Step 3: Cut the sublist and reverse it
        R.next = null;
        ListNode reversed = reverseList(L);

        // Step 4: Reconnect the reversed sublist
        LP.next = reversed;
        L.next = RN; // `L` is now the last node of the reversed sublist

        // Step 5: Return the new head (important if `left == 1`)
        return dummy.next;
    }

    // https://leetcode.com/problems/palindrome-linked-list/
    // Easy
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode middle = middleNode(head);
        ListNode reversed = reverseList(middle);
        ListNode firstHalf = head;
        ListNode secondHalf = reversed;
        while (secondHalf != null) { // Only need to check second half
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        // Step 4 (Optional): Restore the list to its original form
        reverseList(reversed);
        return true;
    }

    // https://leetcode.com/problems/reorder-list/
    // Medium
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        ListNode middle = middleNode(head);
        ListNode secondHalf = reverseList(middle.next);
        middle.next = null; // Break the original link to prevent cycles

        // Step 2: Merge the first and second halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    // Medium
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }


    // https://leetcode.com/problems/rotate-list/
    // Medium
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ){
            return head;
        }
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        temp.next = head;
        int cut = len - k % len;
        while(cut > 0){
            cut--;
            temp = temp.next;
        }
        ListNode ans = temp.next;
        temp.next = null;
        return ans;
    }
}
