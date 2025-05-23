#include <algorithm>
#include<bits/stdc++.h>
#include <functional>
#include <iostream>
#include <queue>
#include <set>
#include <vector>

using namespace std;

// Algorithms
// Containers
// Functions
// Iterators

// pairs
void explainPair(){
    pair<int, int> p = {1, 3};
    cout << p.first << " " << p.second << endl;

    pair<int, pair<int, int>> pp = {1, {2, 3}};
    cout << pp.second.second << endl;

    pair<int , int> arr[] = {{1, 2}, {3, 4}};

    cout << arr[1].first << endl;
}

void explainVector(){

    vector<int> v;
    v.push_back(1);
    // emplace_back faster than push_back
    v.emplace_back(2);
    v.push_back(3);
    v.emplace_back(4);


    vector<pair<int, int>> v1;
    v1.push_back({1, 2});
    v1.emplace_back(1, 2);

    // 5 instances of 100
    vector<int> v3(5, 100);
    // 4 instances of 0 or garbage value
    vector<int> v4(4);

    vector<int> v5(v);

    vector<bool> v6(10, false);

    vector<int>::iterator it = v.begin();
    it++;
    cout << *(it) << endl;
    vector<int>::iterator ie = v.end();
    vector<int>::reverse_iterator ir = v.rbegin();
    vector<int>::reverse_iterator ire = v.rend();

    cout << v[0] << "==" << v.at(0) << endl;
    cout << v.back() << "==" << v.at(v.size() - 1) << endl;

    for(auto it = v.begin(); it != v.end(); it++){
        cout << *(it) << ", ";
    }

    for(auto it = v.rbegin(); it != v.rend(); it++){
        cout << *(it) << ", ";
    }

    for(auto it : v){
        cout << it << ", ";
    }

    // delete an element
    v.erase(v.begin() + 1);

    // delete in a range [start, end)
    v.erase(v.begin(), v.begin() + 1);

    v.insert(v.begin(), 0);
    v.insert(v.begin(), 1, 2); // 1 instance of 2 inserted

    vector<int>copy(10, 5);
    v.insert(v.begin(), copy.begin() + 1, copy.begin() + 3); // 2 elements of copy is appended to v;

    // v.pop_back();
    v.swap(copy);
    copy.clear();
    cout << v.empty() << endl;
}

void explainList(){
    list<int> l;
    // time complexity for insertion of a element in a vector is costlier than list
    l.push_back(1);
    l.emplace_back(2);
    l.push_front(0);
    l.emplace_front(-1);
    // remaining are same as vector
}

void explainDeque(){
    deque<int> dq;
    dq.push_front(1);
    dq.push_back(2);
    dq.pop_back();
    dq.pop_front();

    dq.front(); dq.back();
}

void explainStack(){
    // O(1) everything
    stack<int> s1, s2;
    s1.push(1); s2.push(2);
    s2.pop(); s2.emplace(2);

    cout << s1.top() << endl;
    s1.swap(s2);
    cout << s1.empty() << endl;
}

void explainQueue(){
    queue<int> q;
    q.push(1); 
    cout << q.front() << endl;
    q.back() += 1;

    cout<<q.back() << endl;

    // other methoeds are same as stack
}

void explainPriorityQueue(){
    priority_queue<int> pq; // default is max heap
    pq.emplace(1); pq.push(10);
    cout << pq.top() << endl; // pq.pop()
    // push and pop in O(logn), top in O(1)
    priority_queue<int, vector<int>, greater<int>> mh;  // min heap declaration
    mh.push(1); mh.emplace(2);
    cout << mh.top() << endl; // 1
}

void explainSet(){
    set<int> s;
    s.emplace(1);
    s.insert(2);
    s.insert(3);
    s.insert(1);

    // sorted and unique, begin(), end() same as vector

    auto it = s.find(1); // returns the item's iterator

    auto it1 = s.find(6); // not found, returns s.end();

    cout << (it1 == s.end()) << endl;

    s.erase(3); // log time, pass iterator or iterators (deletes in that range of numbers)
    int cnt = s.count(1);

    auto it2 = s.lower_bound(1); auto it3 = s.upper_bound(4);
}

void explainMultiSet(){
    // stores duplicates
    multiset<int> ms;
    ms.insert(1);
    ms.insert(1);
    ms.insert(1);
    ms.insert(1);
    ms.erase(1); // all 1's are removed

    int cnt = ms.count(1);
    ms.erase(ms.find(1)); // only one one is deleted

    // ms.erase(ms.find(1), ms.find(1) + 2); // 2 one one is deleted
}

void explainUnorderedSet(){
    unordered_set<int> uos;
    // same as set, but no order like sorted order in set, multiset is maintained
    // better time complexity than set
    // lower_bound and upper_bound doesn't work
    // most of operations as O(1) or linear time
}

void explainMap(){
    map<int, int> mp;
    // sorted order of key, no duplicates allowed
    mp[1] = 2; // map[key] = value;
    mp.emplace(2, 3);
    mp.insert({3, 4});

    for(auto it : mp){
        cout << it.first << "->" << it.second << endl;
    }
    // find() returns iterator, erase, swap, size, empty, lower_bound, upper_bound
    cout << mp[11] << "doesn't exist, so it prints zero or null" << endl;
}

void explainMultiMap(){
    // same as map, but multiple keys are used, only map[key] cannot be used
}

void explainUnorderedMap(){
    // unique keys and not sorted
    // same as set and unordered set differences apply
}

bool comp(pair<int, int> p1, pair<int, int> p2){
    if(p1.second < p2.second) return true;
    if(p1.second > p2.second) return false;
    return p1.first > p2.first;
}

void explainAlgorithms(){
    vector<int>v;
    for(int i  = 10; i > 1; i--){
        v.push_back(i);
    }

    sort(v.begin(), v.begin() + 2); // first two are sorted

    // sorting in decending order
    sort(v.begin(), v.end(), greater<int>());
    // greater<int>() is comparator


    vector<pair<int, int>> v1 = {{1,2}, {2, 2}, {2, 3}, {4, 5}};

    // custom sorting criteria
    sort(v1.begin(), v1.end(), comp); // comp is comparator which return bool
    // sorted it according to pair.second value in ascending
    // if they are equal, consider pair.first but in descending

    int num = 7;
    int count = __builtin_popcount(num); // return the number of set bits in the 32 bit space of the variable

    long long n = 9876543212345;
    cout << __builtin_popcountll(n) << endl; // for long long

    string s = "123";
    sort(s.begin(), s.end());
    do{
        cout << s << endl; 
    } while(next_permutation(s.begin(), s.end()));

    int max = *max_element(v.begin(), v.end()); // returns max element in a given iterator range
}

int main(){

    // explainPair();
    // explainVector();
    return 0;
}