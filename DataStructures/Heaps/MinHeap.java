package DataStructures.Heaps;

import java.util.ArrayList;

public class MinHeap {
    /*
     * find min in O(1) Time Complexity
     * Insertion and Deletion in O(log(N))
     * 1. Complete Binary Trees
     * 2. Every node val < the val of its children
     * 
     * Parent(i) = (i - 1) / 2;
     * leftChild(i) = 2 * i + 1;
     * rightChild(i) = 2 * i + 2;
     * height of the tree = Math.log(n);
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
            if (list.get(idx).compareTo(list.get(par)) < 0) {
                swap(idx, par);
                upheap(par);
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Heap is Empty");
            }
            T temp = list.get(0);
            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }
            return temp;
        }

        private void downheap(int idx) {
            int min = idx;
            int li = left(idx);
            int ri = right(idx);
            if (li < list.size() && list.get(min).compareTo(list.get(li)) > 0) {
                min = li;
            }

            if (ri < list.size() && list.get(min).compareTo(list.get(ri)) > 0) {
                min = ri;
            }

            if (min != idx) {
                swap(min, idx);
                downheap(min);
            }
        }

        /*
         * Let’s say we build a min-heap from an unsorted array:
         * - Leaf nodes (N/2 of them) require 0 work.
         * - Level above leaves (N/4 nodes) may require 1 comparison/swap (cost = c).
         * - Next level (N/8 nodes), cost = 2c
         * - And so on...
         * Total work = (N/2)*0 + (N/4)*c + (N/8)*2c + (N/16)*3c + ... + 1*logN*c
         * This sums to a finite series and results in O(N) time.
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

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);

        System.out.print("Heap Sort Output: ");
        ArrayList<Integer> sorted = heap.heapSort();
        for (Integer val : sorted) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
