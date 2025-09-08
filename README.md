# DSA Pattern Recognition Guide 🎯

A systematic approach to identify problem patterns and choose the right data structure/algorithm for coding interviews and competitive programming.

## 🧭 How to Use This Guide

When you encounter a problem, follow this decision tree:

1. **Read the problem statement carefully**
2. **Identify key characteristics** (input/output, constraints, operations needed)
3. **Match with patterns below** to find the right folder
4. **Practice similar problems** in that category

---

## 📋 Pattern Recognition Framework

### 🔍 **Array/String Problems**

#### **When to Use Sliding Window** → [📁 `/SlidingWindow/`](./SlidingWindow/)
**🔍 Identify by:**
- Find optimal subarray/substring 
- Keywords: "maximum sum", "minimum length", "contains all characters"
- Contiguous elements matter
- Need to optimize window size

**📝 Examples:**
- Maximum sum subarray of size K
- Longest substring without repeating characters
- Minimum window substring

**📂 Practice Files:**
- [questions.java](./SlidingWindow/questions.java) - Collection of sliding window problems

---

#### **When to Use Two Pointers** → [📁 `/SearchingTechniques/`](./SearchingTechniques/) or custom implementations
**🔍 Identify by:**
- Array is sorted or can be sorted
- Need to find pairs/triplets with specific sum
- Keywords: "two sum", "palindrome", "remove duplicates"
- Can work from both ends

**📝 Examples:**
- Two sum in sorted array
- Valid palindrome
- Container with most water

---

### 🔄 **Backtracking Problems** → [📁 `/BackTracking/`](./BackTracking/)

**🔍 Identify by:**
- Need to find ALL solutions
- Keywords: "generate all", "find all combinations", "permutations"
- Can break into smaller subproblems
- Need to explore and backtrack

**📂 Specific Problems:**
- **N-Queens Problem** → [📁 `/BackTracking/NQueens/`](./BackTracking/NQueens/)
  - [NQueens.java](./BackTracking/NQueens/NQueens.java), [NQueens.cpp](./BackTracking/NQueens/NQueens.cpp), [NQueens.py](./BackTracking/NQueens/NQueens.py), [NQueens.c](./BackTracking/NQueens/NQueens.c), [NQueens.js](./BackTracking/NQueens/NQueens.js)
  - [Description.md](./BackTracking/NQueens/Description.md) - Problem explanation
- **N-Knights Problem** → [📁 `/BackTracking/NKnights/`](./BackTracking/NKnights/)
  - [Nknights.java](./BackTracking/NKnights/Nknights.java)
- **Sudoku Solver** → [📁 `/BackTracking/Sudoku/`](./BackTracking/Sudoku/)
  - [SudokuSolver.java](./BackTracking/Sudoku/SudokuSolver.java)
- **Maze Problems** → [📁 `/BackTracking/Maze/`](./BackTracking/Maze/)
  - [Maze.java](./BackTracking/Maze/Maze.java)
- **Max Length Problems** → [📁 `/BackTracking/MaxLength/`](./BackTracking/MaxLength/)
  - [MaxLength.java](./BackTracking/MaxLength/MaxLength.java)

---

### 🌳 **Tree Problems** → [📁 `/DataStructures/Trees/`](./DataStructures/Trees/)

**🔍 Identify by:**
- Hierarchical data structure
- Keywords: "binary tree", "root", "leaf", "ancestor", "depth"

**📂 Navigation Guide:**
- **Level-order traversal** → [📁 `/Trees/Questions/BFS/`](./DataStructures/Trees/Questions/BFS/)
  - [Q101.java](./DataStructures/Trees/Questions/BFS/Q101.java) - Symmetric Tree
  - [Q102_Q107.java](./DataStructures/Trees/Questions/BFS/Q102_Q107.java) - Level Order Traversal
  - [Q116.java](./DataStructures/Trees/Questions/BFS/Q116.java) - Populating Next Right Pointers
  - [Q637.java](./DataStructures/Trees/Questions/BFS/Q637.java) - Average of Levels
  - [Q993.java](./DataStructures/Trees/Questions/BFS/Q993.java) - Cousins in Binary Tree

- **Pre/In/Post-order, Path problems** → [📁 `/Trees/Questions/DFS/`](./DataStructures/Trees/Questions/DFS/)
  - [Q104.java](./DataStructures/Trees/Questions/DFS/Q104.java) - Maximum Depth
  - [Q105.java](./DataStructures/Trees/Questions/DFS/Q105.java) - Construct Tree from Preorder/Inorder
  - [Q114.java](./DataStructures/Trees/Questions/DFS/Q114.java) - Flatten Tree to Linked List
  - [Q124.java](./DataStructures/Trees/Questions/DFS/Q124.java) - Binary Tree Maximum Path Sum
  - [Q226.java](./DataStructures/Trees/Questions/DFS/Q226.java) - Invert Binary Tree
  - [Q236.java](./DataStructures/Trees/Questions/DFS/Q236.java) - Lowest Common Ancestor
  - [Q543.java](./DataStructures/Trees/Questions/DFS/Q543.java) - Diameter of Binary Tree

- **Popular interview problems** → [📁 `/Trees/Questions/Striver/`](./DataStructures/Trees/Questions/Striver/)
  - [Hard.java](./DataStructures/Trees/Questions/Striver/Hard.java) - Hard tree problems
  - [Q863.java](./DataStructures/Trees/Questions/Striver/Q863.java) - All Nodes Distance K

- **Tree fundamentals** → [📁 `/Trees/Theory/`](./DataStructures/Trees/Theory/)
  - [BinaryTree.java](./DataStructures/Trees/Theory/BinaryTree.java) - Basic binary tree implementation
  - [BinarySearchTree.java](./DataStructures/Trees/Theory/BinarySearchTree.java) - BST implementation
  - [AVLTree.java](./DataStructures/Trees/Theory/AVLTree.java) - Self-balancing tree
  - [SegmentTree.java](./DataStructures/Trees/Theory/SegmentTree.java) - Range query tree
  - [Traversal.java](./DataStructures/Trees/Theory/Traversal.java), [Traversal.cpp](./DataStructures/Trees/Theory/Traversal.cpp) - Tree traversal methods

---

### 🕸️ **Graph Problems** → [📁 `/DataStructures/Graphs/`](./DataStructures/Graphs/)

**🔍 Identify by:**
- Nodes and edges relationship
- Keywords: "network", "connections", "islands", "shortest path"

**📂 Navigation Guide:**
- **Graph Fundamentals** → [📁 `/Graphs/Learning/`](./DataStructures/Graphs/Learning/)
  - [BFS.java](./DataStructures/Graphs/Learning/BFS.java), [DFS.java](./DataStructures/Graphs/Learning/DFS.java) - Basic traversal
  - [BipartiteGraph.java](./DataStructures/Graphs/Learning/BipartiteGraph.java) - Bipartite graph detection
  - [Components.java](./DataStructures/Graphs/Learning/Components.java) - Connected components
  - [Cycles.java](./DataStructures/Graphs/Learning/Cycles.java) - Cycle detection

- **Shortest Path** → [📁 `/Graphs/Algorithms/Path/`](./DataStructures/Graphs/Algorithms/Path/)
  - [DijkstrasAlgorithm.java](./DataStructures/Graphs/Algorithms/Path/DijkstrasAlgorithm.java) - Single source shortest path
  - [BellmanFordAlgorithm.java](./DataStructures/Graphs/Algorithms/Path/BellmanFordAlgorithm.java) - Handles negative weights
  - [FloydWarshallAlgorithm.java](./DataStructures/Graphs/Algorithms/Path/FloydWarshallAlgorithm.java) - All pairs shortest path
  - [GridProblems.java](./DataStructures/Graphs/Algorithms/Path/GridProblems.java) - 2D grid pathfinding

- **Minimum Spanning Tree** → [📁 `/Graphs/Algorithms/MinimumSpanningTree/`](./DataStructures/Graphs/Algorithms/MinimumSpanningTree/)
  - [KruskalsAlgorithm.java](./DataStructures/Graphs/Algorithms/MinimumSpanningTree/KruskalsAlgorithm.java) - Edge-based MST
  - [PrimsAlgorithm.java](./DataStructures/Graphs/Algorithms/MinimumSpanningTree/PrimsAlgorithm.java) - Vertex-based MST
  - [DisjointSetRank.java](./DataStructures/Graphs/Algorithms/MinimumSpanningTree/DisjointSetRank.java), [DisjointSetSize.java](./DataStructures/Graphs/Algorithms/MinimumSpanningTree/DisjointSetSize.java) - Union-Find

- **Topological Sort** → [📁 `/Graphs/Algorithms/Sorting/`](./DataStructures/Graphs/Algorithms/Sorting/)
  - [TopologicalSort.java](./DataStructures/Graphs/Algorithms/Sorting/TopologicalSort.java) - DAG ordering

- **Advanced Graph Algorithms** → [📁 `/Graphs/Algorithms/Others/`](./DataStructures/Graphs/Algorithms/Others/)
  - [KosarajusAlgorithm.java](./DataStructures/Graphs/Algorithms/Others/KosarajusAlgorithm.java) - Strongly connected components
  - [TarjansAlgorithm.java](./DataStructures/Graphs/Algorithms/Others/TarjansAlgorithm.java) - Bridges and articulation points

---

### 💰 **Dynamic Programming** → [📁 `/DynamicProgramming/`](./DynamicProgramming/)

**🔍 Identify by:**
- Optimization problems (max/min)
- Overlapping subproblems
- Keywords: "maximum", "minimum", "count ways", "optimal"
- Can break into smaller similar problems

**📂 Pattern-wise Navigation:**
- **1D Array problems** → [📁 `/DynamicProgramming/ONEDDP/`](./DynamicProgramming/ONEDDP/)
  - [HouseRobber.java](./DynamicProgramming/ONEDDP/HouseRobber.java) - House Robber problem
  - [OneDimensionalDP.java](./DynamicProgramming/ONEDDP/OneDimensionalDP.java) - 1D DP patterns

- **2D Grid problems** → [📁 `/DynamicProgramming/Grids/`](./DynamicProgramming/Grids/) & [📁 `/DynamicProgramming/TWODDP/`](./DynamicProgramming/TWODDP/)
  - [Rectangle.java](./DynamicProgramming/Grids/Rectangle.java), [Square.java](./DynamicProgramming/Grids/Square.java) - Grid DP problems
  - [Training.java](./DynamicProgramming/TWODDP/Training.java) - 2D DP training problems

- **String matching** → [📁 `/DynamicProgramming/Strings/`](./DynamicProgramming/Strings/)
  - [LongestCommonSubsequence.java](./DynamicProgramming/Strings/LongestCommonSubsequence.java) - LCS
  - [EditDistance.java](./DynamicProgramming/Strings/EditDistance.java) - String edit distance
  - [LongestPalindromicSubsequence.java](./DynamicProgramming/Strings/LongestPalindromicSubsequence.java) - Palindromic subsequence

- **Subsequence problems** → [📁 `/DynamicProgramming/SubSequences/`](./DynamicProgramming/SubSequences/)
  - [Knapsack.java](./DynamicProgramming/SubSequences/Knapsack.java) - 0/1 Knapsack
  - [Coins.java](./DynamicProgramming/SubSequences/Coins.java) - Coin change problems
  - [SubSetSums.java](./DynamicProgramming/SubSequences/SubSetSums.java) - Subset sum variations

- **Stock trading** → [📁 `/DynamicProgramming/Stocks/`](./DynamicProgramming/Stocks/)
  - [BuyandSellStocksI.java](./DynamicProgramming/Stocks/BuyandSellStocksI.java) to [BuyandSellStocksIV.java](./DynamicProgramming/Stocks/BuyandSellStocksIV.java)
  - [BuyandSellStocksWithCoolDown.java](./DynamicProgramming/Stocks/BuyandSellStocksWithCoolDown.java), [BuyandSellStocksWithFees.java](./DynamicProgramming/Stocks/BuyandSellStocksWithFees.java)

- **Partition problems** → [📁 `/DynamicProgramming/Partitions/`](./DynamicProgramming/Partitions/)
  - [PalindromePartitioning.java](./DynamicProgramming/Partitions/PalindromePartitioning.java) - String partitioning
  - [MatrixChainMultiplication.java](./DynamicProgramming/Partitions/MatrixChainMultiplication.java) - MCM problem

- **Increasing sequences** → [📁 `/DynamicProgramming/LIS/`](./DynamicProgramming/LIS/)
  - [LongestIncreasingSubsequence.java](./DynamicProgramming/LIS/LongestIncreasingSubsequence.java) - Basic LIS
  - [LongestBitonicSubsequence.java](./DynamicProgramming/LIS/LongestBitonicSubsequence.java) - Bitonic LIS

---

### 🗃️ **Stack Problems** → [📁 `/DataStructures/Stack/`](./DataStructures/Stack/)

**🔍 Identify by:**
- LIFO operations needed
- Keywords: "valid parentheses", "next greater", "histogram"
- Need to remember most recent element

**📂 Practice Files:**
- [myStack.java](./DataStructures/Stack/myStack.java) - Stack implementation
- [Questions.java](./DataStructures/Stack/Questions.java) - Stack practice problems
- [StackDemo.java](./DataStructures/Stack/StackDemo.java) - Stack demonstrations

---

### 📋 **Queue Problems** → [📁 `/DataStructures/Queues/`](./DataStructures/Queues/)

**🔍 Identify by:**
- FIFO operations needed
- Level-order processing
- Keywords: "first come first serve", "process in order"

**📂 Practice Files:**
- [myQueue.java](./DataStructures/Queues/myQueue.java) - Basic queue
- [CircularQueue.java](./DataStructures/Queues/CircularQueue.java) - Circular queue implementation
- [DoublyEndedQueue.java](./DataStructures/Queues/DoublyEndedQueue.java) - Deque implementation
- [Questions.java](./DataStructures/Queues/Questions.java) - Queue practice problems

---

### ⛰️ **Heap Problems** → [📁 `/DataStructures/Heaps/`](./DataStructures/Heaps/)

**🔍 Identify by:**
- Need Kth largest/smallest element
- Keywords: "top K", "median", "priority"
- Merge K sorted arrays/lists

**📂 Practice Files:**
- [MaxHeap.java](./DataStructures/Heaps/MaxHeap.java) - Max heap implementation
- [MinHeap.java](./DataStructures/Heaps/MinHeap.java) - Min heap implementation

---

### 🔗 **Linked List Problems** → [📁 `/DataStructures/LinkedList/`](./DataStructures/LinkedList/)

**🔍 Identify by:**
- Sequential data with pointers
- Keywords: "reverse", "cycle detection", "merge"

**📂 Types:**
- **Basic operations** → [📁 `/LinkedList/SinglyLinkedList/`](./DataStructures/LinkedList/SinglyLinkedList/)
  - [LinkedList.java](./DataStructures/LinkedList/SinglyLinkedList/LinkedList.java), [Node.java](./DataStructures/LinkedList/SinglyLinkedList/Node.java)
- **Advanced operations** → [📁 `/LinkedList/DoublyLinkedList/`](./DataStructures/LinkedList/DoublyLinkedList/), [📁 `/LinkedList/CircularLinkedList/`](./DataStructures/LinkedList/CircularLinkedList/)
  - [DLL.java](./DataStructures/LinkedList/DoublyLinkedList/DLL.java) - Doubly linked list
  - [LRUCache.java](./DataStructures/LinkedList/DoublyLinkedList/LRUCache.java) - LRU Cache implementation
  - [CLL.java](./DataStructures/LinkedList/CircularLinkedList/CLL.java) - Circular linked list
- **Interview questions** → [📁 `/LinkedList/LeetcodeQuestions/`](./DataStructures/LinkedList/LeetcodeQuestions/)
  - [Questions.java](./DataStructures/LinkedList/LeetcodeQuestions/Questions.java) - LeetCode problems

---

### 🔄 **Recursion** → [📁 `/Recursion/`](./Recursion/)

**🔍 Identify by:**
- Problem can be broken into similar smaller problems
- Tree-like decision making
- Base case + recursive case clear

**📂 Practice Files:**
- **Array Recursion** → [📁 `/Recursion/Arrays/`](./Recursion/Arrays/)
  - [Searching.java](./Recursion/Arrays/Searching.java), [Sorting.java](./Recursion/Arrays/Sorting.java)
- **Permutations** → [📁 `/Recursion/Permutations/Arrays/Permutations/`](./Recursion/Permutations/Arrays/Permutations/)
  - [Combinations.java](./Recursion/Permutations/Arrays/Permutations/Combinations.java)

---

### 🔢 **Mathematical Problems** → [📁 `/Maths/`](./Maths/)

**🔍 Identify by:**
- Number theory, combinatorics
- **Bit manipulation** → [📁 `/Maths/Bitwise/`](./Maths/Bitwise/)
  - [BitwiseOperaters.java](./Maths/Bitwise/BitwiseOperaters.java) - Bitwise operations
  - [📁 Questions](./Maths/Bitwise/Questions/) - [XORQuestions.java](./Maths/Bitwise/Questions/XORQuestions.java), [SingleNumber.java](./Maths/Bitwise/Questions/SingleNumber.java), [PowerofTwo.java](./Maths/Bitwise/Questions/PowerofTwo.java)
- **Number properties** → [📁 `/Maths/Number/`](./Maths/Number/)
  - [PrimeNumbers.java](./Maths/Number/PrimeNumbers.java), [Factors.java](./Maths/Number/Factors.java), [Sqrt.java](./Maths/Number/Sqrt.java)

---

### 🔍 **Search Problems** → [📁 `/SearchingTechniques/`](./SearchingTechniques/)

**🔍 Identify by:**
- **Sorted array/search space** → [📁 `/SearchingTechniques/Binary/`](./SearchingTechniques/Binary/)
  - [Examples.java](./SearchingTechniques/Binary/Examples.java) - Binary search examples
  - [RotatedSortedArray.java](./SearchingTechniques/Binary/RotatedSortedArray.java) - Search in rotated array
  - [MountainArraySearch.java](./SearchingTechniques/Binary/MountainArraySearch.java) - Peak finding
  - [FirstAndLast.java](./SearchingTechniques/Binary/FirstAndLast.java) - Find first/last occurrence

- **Unsorted/small arrays** → [📁 `/SearchingTechniques/Linear/`](./SearchingTechniques/Linear/)
  - [Examples.java](./SearchingTechniques/Linear/Examples.java) - Linear search examples
  - [RichestCustomerWealth.java](./SearchingTechniques/Linear/RichestCustomerWealth.java) - Linear search problems

---

### 📊 **Sorting Problems** → [📁 `/SortingTechniques/`](./SortingTechniques/)

**🔍 Choose by performance needs:**
- **O(n²) acceptable** → [📁 `/BubbleSort/`](./SortingTechniques/BubbleSort/), [📁 `/SelectionSort/`](./SortingTechniques/SelectionSort/), [📁 `/InsertionSort/`](./SortingTechniques/InsertionSort/)
- **O(n log n) needed** → [📁 `/MergeSort/`](./SortingTechniques/MergeSort/), [📁 `/QuickSort/`](./SortingTechniques/QuickSort/), [📁 `/HeapSort/`](./SortingTechniques/HeapSort/)
- **Special cases** → [📁 `/CyclicSort/`](./SortingTechniques/CyclicSort/) (1 to n numbers), [📁 `/RadixSort/`](./SortingTechniques/RadixSort/) (integers)

**📂 Cyclic Sort Problems** → [📁 `/CyclicSort/Questions/`](./SortingTechniques/CyclicSort/Questions/)
- [MissingNumber.java](./SortingTechniques/CyclicSort/Questions/MissingNumber.java) - Find missing number
- [FindDuplicate.java](./SortingTechniques/CyclicSort/Questions/FindDuplicate.java) - Find duplicate in array
- [FindAllDuplicates.java](./SortingTechniques/CyclicSort/Questions/FindAllDuplicates.java) - Find all duplicates

---

### 🎭 **String Problems** → [📁 `/Strings/`](./Strings/)

**🔍 Identify by:**
- String manipulation, pattern matching
- **Permutations** → [📁 `/Strings/Permutations/`](./Strings/Permutations/)
  - [Permutations.java](./Strings/Permutations/Permutations.java)
- **Pattern Matching** → [📁 `/Strings/StringMatching/`](./Strings/StringMatching/)
  - [RabinKarp.cpp](./Strings/StringMatching/RabinKarp.cpp) - String matching algorithm
- **Subsets** → [📁 `/Strings/SubSets/`](./Strings/SubSets/)
  - [SubSets.java](./Strings/SubSets/SubSets.java)

---

### 🏢 **Matrix Problems** → [📁 `/Matrix/`](./Matrix/)

**🔍 Identify by:**
- 2D array operations
- **Practice Files:**
  - [BinarySearch.java](./Matrix/BinarySearch.java) - Binary search in 2D matrix
  - [RowColSorted.java](./Matrix/RowColSorted.java) - Search in row-col sorted matrix
  - [RotateImage.java](./Matrix/RotateImage.java) - Matrix rotation
  - [StaircaseSearch.java](./Matrix/StaircaseSearch.java) - Staircase search pattern

---

## 🎯 Company-Specific Preparation → [📁 `/Placements/`](./Placements/)

### **TCS** → [📁 `/Placements/TCS/`](./Placements/TCS/)
- **Coding Problems** → [📁 `/Placements/TCS/Coding/`](./Placements/TCS/Coding/)
  - [Interview_Questions.txt](./Placements/TCS/Coding/Interview_Questions.txt) - Common TCS questions
  - [Q15_Prime.java](./Placements/TCS/Coding/Q15_Prime.java), [Q19.java](./Placements/TCS/Coding/Q19.java) - Specific TCS problems
- **Interview Guides**
  - [tech-interview-guide.md](./Placements/TCS/tech-interview-guide.md) - TCS interview preparation
  - [tech-interview-questions.md](./Placements/TCS/tech-interview-questions.md) - Technical questions

### **Accenture** → [📁 `/Placements/Accenture/`](./Placements/Accenture/)
- [GUIDE.md](./Placements/Accenture/GUIDE.md) - Accenture preparation guide
- **Reasoning** → [📁 `/Placements/Accenture/Reasoning/`](./Placements/Accenture/Reasoning/)
  - [Questions.md](./Placements/Accenture/Reasoning/Questions.md) - Logical reasoning problems
- **Verbal** → [📁 `/Placements/Accenture/Verbal/`](./Placements/Accenture/Verbal/)
  - [Questions.md](./Placements/Accenture/Verbal/Questions.md) - Verbal ability questions

---

## 📚 **Additional Resources**

### **Books** → [📁 `/Books/`](./Books/)
- [Cracking the Coding Interview.pdf](./Books/Cracking%20the%20Coding%20Interview.pdf) - Essential interview preparation

### **Programming Languages**
- **Java** - Primary language for most implementations
- **C/C++** → [📁 `/STL/`](./STL/) - [main.cpp](./STL/main.cpp) for STL usage
- **Python** → [📁 `/Python/`](./Python/) - [basics.py](./Python/basics.py), [📁 Classes](./Python/Classes/)

### **Object-Oriented Programming** → [📁 `/OOPS/`](./OOPS/)
- **Core Concepts**: [📁 Inheritance](./OOPS/Properties/Inheritance/), [📁 Polymorphism](./OOPS/Properties/Polymorphism/)
- **Advanced Topics**: [📁 Generics](./OOPS/Generics/), [📁 Interfaces](./OOPS/Interfaces/), [📁 Abstract Classes](./OOPS/AbstractClasses/)

---

## 🚀 Quick Decision Flowchart

```
📝 Problem Given
    ↓
🤔 What's the main operation?
    ↓
┌─────────────────────────────────────────┐
│ FIND OPTIMAL SUBARRAY/SUBSTRING?        │ → SlidingWindow
│ GENERATE ALL COMBINATIONS?              │ → BackTracking  
│ SHORTEST PATH/NETWORK?                  │ → Graphs
│ OPTIMIZATION WITH SUBPROBLEMS?          │ → DynamicProgramming
│ HIERARCHICAL DATA?                      │ → Trees
│ LIFO OPERATIONS?                        │ → Stack
│ KTH LARGEST/SMALLEST?                   │ → Heaps
│ SORTED ARRAY SEARCH?                    │ → BinarySearch
│ MATHEMATICAL PATTERN?                   │ → Maths
└─────────────────────────────────────────┘
```

## 💡 Pro Tips

1. **Start with brute force** - understand the problem first
2. **Look for patterns** - similar problems often have similar solutions  
3. **Time/Space complexity** - guides which approach to use
4. **Practice consistently** - pattern recognition improves with exposure
5. **Use the hyperlinks** - Click on folder/file links to navigate directly to implementations

---

## 📈 Study Order Recommendation

1. **Basics** → [Arrays](./SlidingWindow/), [Searching](./SearchingTechniques/), [Sorting](./SortingTechniques/)
2. **Data Structures** → [Stack](./DataStructures/Stack/), [Queue](./DataStructures/Queues/), [LinkedList](./DataStructures/LinkedList/)  
3. **Trees & Graphs** → [Trees](./DataStructures/Trees/), [Graphs](./DataStructures/Graphs/)
4. **Advanced** → [Dynamic Programming](./DynamicProgramming/), [BackTracking](./BackTracking/)
5. **Optimization** → [Maths](./Maths/), [Heaps](./DataStructures/Heaps/)
6. **Company Prep** → [TCS](./Placements/TCS/), [Accenture](./Placements/Accenture/)

---
**Happy Pattern Hunting! 🎯**

---
*Click on any folder/file link above to navigate directly to the implementation!*