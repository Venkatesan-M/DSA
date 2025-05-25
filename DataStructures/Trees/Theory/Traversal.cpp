#include <bits/stdc++.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

// --- Recursive DFS Traversals ---

// Pre-order Traversal (Node -> Left -> Right)
void preOrder(TreeNode *node) {
    if (node == nullptr) {
        return;
    }
    cout << node->val << " ";
    preOrder(node->left);
    preOrder(node->right);
}

// In-order Traversal (Left -> Node -> Right)
void inOrder(TreeNode *node) {
    if (node == nullptr) {
        return;
    }
    inOrder(node->left);
    cout << node->val << " ";
    inOrder(node->right);
}

// Post-order Traversal (Left -> Right -> Node)
void postOrder(TreeNode *node) {
    if (node == nullptr) {
        return;
    }
    postOrder(node->left);
    postOrder(node->right);
    cout << node->val << " ";
}

// --- Iterative DFS Traversals ---

// Pre-order Traversal using a stack (Node -> Left -> Right)
void preOrderStack(TreeNode *node) {
    if (node == nullptr) {
        return;
    }
    stack<TreeNode *> st;
    st.push(node);

    while (!st.empty()) {
        TreeNode *curr = st.top();
        st.pop();
        cout << curr->val << " ";

        // Push right then left, so left is processed first (LIFO)
        if (curr->right != nullptr) {
            st.push(curr->right);
        }
        if (curr->left != nullptr) {
            st.push(curr->left);
        }
    }
}

// In-order Traversal using a single stack (Left -> Node -> Right)
void inOrderStack(TreeNode *node) {
    stack<TreeNode *> st;
    TreeNode *curr = node;

    while (curr != nullptr || !st.empty()) {
        // Go left as far as possible, pushing nodes
        while (curr != nullptr) {
            st.push(curr);
            curr = curr->left;
        }

        curr = st.top(); // Get the leftmost node
        st.pop();
        cout << curr->val << " "; // Process node

        curr = curr->right; // Move to right subtree
    }
}

// Post-order Traversal using two stacks (Left -> Right -> Node)
void postOrderTwoStacks(TreeNode *root) {
    if (root == nullptr) {
        return;
    }
    stack<TreeNode *> st1; // Primary traversal stack
    stack<TreeNode *> st2; // Stores nodes in post-order

    st1.push(root);

    while (!st1.empty()) {
        TreeNode *curr = st1.top();
        st1.pop();
        st2.push(curr); // Add to second stack

        // Push left then right to st1, resulting in (Node, Right, Left) in st2
        if (curr->left != nullptr) {
            st1.push(curr->left);
        }
        if (curr->right != nullptr) {
            st1.push(curr->right);
        }
    }

    // Print elements from st2 (which are now in correct post-order)
    while (!st2.empty()) {
        cout << st2.top()->val << " ";
        st2.pop();
    }
}

// Post-order Traversal using one stack (Left -> Right -> Node)
void postOrderStack(TreeNode *root) {
    if (root == nullptr) {
        return;
    }

    stack<TreeNode *> st;
    TreeNode *curr = root;
    TreeNode *lastVisited = nullptr; // Tracks the last processed node

    while (curr != nullptr || !st.empty()) {
        if (curr != nullptr) {
            st.push(curr);
            curr = curr->left;
        } else {
            TreeNode *temp = st.top()->right;
            if (temp == nullptr || temp == lastVisited) {
                // No right child or right child already visited; process current
                temp = st.top();
                st.pop();
                cout << temp->val << " ";
                lastVisited = temp;
            } else {
                curr = temp; // Move to unvisited right child
            }
        }
    }
}

// Single Pass for Pre-order, In-order, and Post-order
// Uses a stack of pair<TreeNode*, int> where int signifies visit stage (1=pre, 2=in, 3=post)
void PreInPostOrder(TreeNode *root) {
    if (root == nullptr) {
        return;
    }

    vector<int> preOrderVec;
    vector<int> inOrderVec;
    vector<int> postOrderVec;
    stack<pair<TreeNode *, int>> st;

    st.push({root, 1}); // Start with root, stage 1

    while (!st.empty()) {
        pair<TreeNode *, int> p = st.top();
        st.pop();

        if (p.second == 1) { // Stage 1: Pre-order
            preOrderVec.push_back(p.first->val);
            p.second++;
            st.push(p); // Push back for in-order

            if (p.first->left != nullptr) {
                st.push({p.first->left, 1}); // Go left
            }
        } else if (p.second == 2) { // Stage 2: In-order
            inOrderVec.push_back(p.first->val);
            p.second++;
            st.push(p); // Push back for post-order

            if (p.first->right != nullptr) {
                st.push({p.first->right, 1}); // Go right
            }
        } else { // Stage 3: Post-order
            postOrderVec.push_back(p.first->val);
        }
    }

    cout << "--- Traversal Results (1-Pass Iterative) ---" << endl;
    cout << "Pre-order (1-pass): ";
    for (int val : preOrderVec) cout << val << " ";
    cout << endl;

    cout << "In-order (1-pass): ";
    for (int val : inOrderVec) cout << val << " ";
    cout << endl;

    cout << "Post-order (1-pass): ";
    for (int val : postOrderVec) cout << val << " ";
    cout << endl;
}

// --- Breadth-First Search (BFS) / Level-order Traversal ---

void bfs(TreeNode *root) {
    if (root == nullptr) {
        return;
    }

    queue<TreeNode *> q; // Queue for level-order processing
    q.push(root);

    while (!q.empty()) {
        TreeNode *node = q.front();
        q.pop();
        cout << node->val << " ";

        if (node->left != nullptr) {
            q.push(node->left);
        }
        if (node->right != nullptr) {
            q.push(node->right);
        }
    }
}

// Iterative Depth-First Search (typically pre-order)
void dfs(TreeNode *root) {
    // This is identical to preOrderStack
    if (root == nullptr) {
        return;
    }

    stack<TreeNode *> st;
    st.push(root);

    while (!st.empty()) {
        TreeNode *node = st.top();
        st.pop();
        cout << node->val << " ";

        if (node->right != nullptr) {
            st.push(node->right);
        }
        if (node->left != nullptr) {
            st.push(node->left);
        }
    }
}

// Main function to demonstrate all tree traversals
int main() {
    /*
        Sample binary tree:
              1
             / \
            2   3
           / \   \
          4   5   6
    */
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->right = new TreeNode(6);

    cout << "--- Recursive DFS Traversals ---" << endl;
    cout << "Pre-order: ";
    preOrder(root);
    cout << endl;

    cout << "In-order: ";
    inOrder(root);
    cout << endl;

    cout << "Post-order: ";
    postOrder(root);
    cout << endl << endl;

    cout << "--- Iterative DFS Traversals ---" << endl;
    cout << "Pre-order (Iterative): ";
    preOrderStack(root);
    cout << endl;

    cout << "In-order (Iterative): ";
    inOrderStack(root);
    cout << endl;

    cout << "Post-order (Iterative, Two Stacks): ";
    postOrderTwoStacks(root);
    cout << endl;

    cout << "Post-order (Iterative, One Stack): ";
    postOrderStack(root);
    cout << endl << endl;

    PreInPostOrder(root);
    cout << endl;

    cout << "--- Breadth-First Search (BFS) ---" << endl;
    cout << "BFS (Level-order): ";
    bfs(root);
    cout << endl << endl;

    cout << "--- Iterative DFS (Pre-order equivalent) ---" << endl;
    cout << "DFS (Iterative): "; // This is typically pre-order
    dfs(root);
    cout << endl;

    // Clean up memory
    delete root->left->left;
    delete root->left->right;
    delete root->right->right;
    delete root->left;
    delete root->right;
    delete root;

    return 0;
}