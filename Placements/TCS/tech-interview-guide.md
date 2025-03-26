# Comprehensive Tech Interview Guide

## 1. Garbage Collector
A garbage collector is an automatic memory management mechanism in programming languages like Java, Python, and C#. It automatically frees up memory that is no longer being used by the program, preventing memory leaks and reducing manual memory management overhead.

## 2. AI, ML, DL Definitions
- **Artificial Intelligence (AI)**: The broader concept of machines being able to carry out tasks in a way that we would consider "smart" or "intelligent".
- **Machine Learning (ML)**: A subset of AI that focuses on the ability of machines to receive data and learn for themselves, changing their algorithms without being explicitly programmed.
- **Deep Learning (DL)**: A subset of machine learning based on artificial neural networks, which can learn and make intelligent decisions on their own.

## 3. Spanning Tree
A spanning tree is a subset of a connected, undirected graph that includes all vertices with the minimum possible number of edges, without creating any cycles. In other words, it's a tree that connects all nodes in a graph with the minimum total edge weight.

## 4. Storage Classes in C
1. **auto**: Default storage class for local variables
2. **register**: Stores variables in CPU registers for faster access
3. **static**: Preserves variable value between function calls
4. **extern**: Declares a global variable that's defined in another file

## 5. Cloud Computing
Cloud computing is the delivery of computing services (servers, storage, databases, networking, software) over the internet. It allows users to access and use computing resources remotely without direct active management by the user.

## 6. Dangling Pointer
A dangling pointer is a pointer that references a memory location that has been freed or deleted, making it invalid. Accessing a dangling pointer can lead to undefined behavior or program crashes.

## 7. SQL Commands
- **DDL (Data Definition Language)**: CREATE, ALTER, DROP, TRUNCATE
- **DML (Data Manipulation Language)**: SELECT, INSERT, UPDATE, DELETE
- **DCL (Data Control Language)**: GRANT, REVOKE

## 8. Big Data Analytics Characteristics
1. Volume: Large amounts of data
2. Velocity: High-speed data generation and processing
3. Variety: Different types of data
4. Veracity: Data quality and reliability
5. Value: Extracting meaningful insights

## 9. Exception Handling
Exception handling is a programming language mechanism to handle runtime errors. It allows graceful error management through try-catch blocks, preventing program termination and providing alternative execution paths.

## 10. DELETE vs TRUNCATE in SQL
- **DELETE**: Removes specific rows, can be rolled back
- **TRUNCATE**: Removes all rows, faster, cannot be rolled back

## 11. Types of Protocols
1. **TCP/IP**: Transmission Control Protocol/Internet Protocol
2. **HTTP/HTTPS**: Hypertext Transfer Protocol
3. **FTP**: File Transfer Protocol
4. **UDP**: User Datagram Protocol
5. **SMTP**: Simple Mail Transfer Protocol

## 12. Binary Search Program (Python)
```python
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1  # Element not found

# Example usage
sorted_array = [1, 3, 5, 7, 9, 11, 13]
print(binary_search(sorted_array, 7))  # Output: 3
```

## 13. Data Abstraction
Data abstraction is a programming concept that shows only essential attributes and hides unnecessary details. It helps in reducing programming complexity and increasing efficiency.

## 14. Memory Alignment
Memory alignment is the way data is arranged and accessed in computer memory. It ensures that data is stored at memory addresses that are multiples of a specific size to optimize performance.

## 15. Linked List Functionalities
1. Insertion of elements
2. Deletion of elements
3. Traversing the list
4. Searching for an element
5. Reversing the list
6. Merging lists

## 16. Recursive Function
A recursive function is a function that calls itself during its execution. It uses a stack data structure to maintain function call states and track recursive calls.

## 17. Operator new vs new Operator
- **new operator**: Allocates memory and calls constructor
- **operator new**: Only allocates memory without calling constructor

## 18. Half Pyramid Number Pattern
```python
def print_half_pyramid(rows):
    for i in range(1, rows + 1):
        for j in range(1, i + 1):
            print(j, end=" ")
        print()

print_half_pyramid(5)
```

## 19. Shared Pointer
A shared pointer is a smart pointer in C++ that allows multiple pointers to reference the same memory location. It automatically manages memory by keeping a reference count and deleting the object when no references remain.

## 20. Preferred Programming Language
Preference depends on the specific use case:
- C: Low-level system programming
- C++: System/game development, performance-critical applications
- Java: Enterprise applications, Android development

## 21. Hash Query
A hash query is a database operation that uses hash tables to quickly retrieve or store data, providing fast access with O(1) time complexity.

## 22. Swap Two Numbers Without Third Variable
```python
def swap_numbers(a, b):
    a = a ^ b
    b = a ^ b
    a = a ^ b
    return a, b

x, y = 5, 10
x, y = swap_numbers(x, y)
print(f"x: {x}, y: {y}")
```

## 23. Primary Key and Reference Key
- **Primary Key**: Unique identifier for a table's records
- **Reference Key (Foreign Key)**: Links two tables by referencing the primary key of another table

## 24. DBMS
Database Management System (DBMS) is software that manages databases, providing an interface for storing, retrieving, and manipulating data efficiently.

## 25. Database Concepts
- **Views**: Virtual tables based on SQL statement results
- **Normalization**: Organizing data to reduce redundancy
- **Recursion**: Process of solving problems by solving smaller instances of the same problem

## 26. Software Development Cycle
1. Requirements gathering
2. Design
3. Implementation
4. Testing
5. Deployment
6. Maintenance

## 27. Classes vs Interfaces
- **Classes**: Blueprint for objects, can have implementation
- **Interfaces**: Define contract, only method signatures

## 28. Function vs Method
- **Function**: Standalone block of code
- **Method**: Function associated with a class or object

## DSA & Algorithms Roadmap
### Arrays
1. Basic operations
2. Searching algorithms
3. Sorting techniques

### Strings
1. String manipulation
2. Pattern matching
3. Compression techniques

### Conversions
1. Number system conversions
2. Data type transformations

### Number Series
1. Fibonacci
2. Prime numbers
3. Arithmetic progressions

### Sorting Algorithms
1. Bubble Sort
2. Quick Sort
3. Merge Sort
4. Insertion Sort

### Graph Algorithms
1. Breadth-First Search
2. Depth-First Search
3. Shortest Path Algorithms

### Tree Algorithms
1. Tree Traversals
2. Binary Search Trees
3. AVL Trees
4. Red-Black Trees

### Dynamic Programming
1. Knapsack Problem
2. Longest Common Subsequence
3. Matrix Chain Multiplication

### Stack & Queue
1. Implementation
2. Applications
3. Limitations

### Advanced Algorithms
1. Bellman-Ford
2. Dijkstra's Algorithm
3. Knapsack Variants
