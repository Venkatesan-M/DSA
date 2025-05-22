package DataStructures.Heaps;

import java.util.ArrayList;

public class MaxHeap {
    /*
     * MaxHeap:
     * - find max in O(1)
     * - insert/delete in O(log N)
     * - based on a Complete Binary Tree
     */

    public static class Heap<T extends Comparable<T>> {
        private ArrayList<T> list;

        public Heap() {
            list = new ArrayList<>();
        }

        private void swap(int i, int j) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        private int parent(int idx) {
            return (idx - 1) / 2;
        }

        private int left(int idx) {
            return 2 * idx + 1;
        }

        private int right(int idx) {
            return 2 * idx + 2;
        }

        public T peek() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Heap is Empty");
            }
            return list.get(0);
        }

        public void insert(T val) {
            list.add(val);
            upheap(list.size() - 1);
        }

        private void upheap(int idx) {
            if (idx == 0) return;
            int par = parent(idx);
            if (list.get(idx).compareTo(list.get(par)) > 0) { // > for max-heap
                swap(idx, par);
                upheap(par);
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Heap is Empty");
            }
            T max = list.get(0);
            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }
            return max;
        }

        private void downheap(int idx) {
            int max = idx;
            int li = left(idx);
            int ri = right(idx);

            if (li < list.size() && list.get(max).compareTo(list.get(li)) < 0) {
                max = li;
            }

            if (ri < list.size() && list.get(max).compareTo(list.get(ri)) < 0) {
                max = ri;
            }

            if (max != idx) {
                swap(max, idx);
                downheap(max);
            }
        }

        // Actually O(N) time
        /*
         * 
         * Leaf Nodes = N/2; time = 0
         * Level 1 = N/4; time = c
         * Level 2 = N/8; time = 2c
         * Level 3 = N/16; time = 3c
         * ...
         * ...
         * ...
         * root = 1
         * 
         */
    
        public ArrayList<T> heapSort() throws Exception {
            ArrayList<T> result = new ArrayList<>();
            Heap<T> copy = new Heap<>();
            for (T item : this.list) {
                copy.insert(item);
            }

            while (!copy.list.isEmpty()) {
                result.add(copy.remove());
            }

            return result;
        }
    }

    // Test the MaxHeap
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);

        System.out.println("MaxHeap Sort Output (Descending):");
        ArrayList<Integer> sorted = heap.heapSort();
        for (Integer val : sorted) {
            System.out.print(val + " ");
        }
    }
}
