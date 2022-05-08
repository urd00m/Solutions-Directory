/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

class NestedIterator {
public:
    vector<int> v;
    long idx; 
    NestedIterator(vector<NestedInteger> &nestedList) {
        v = vector<int>(0, 0); 
        for(long i = 0; i < nestedList.size(); i++) 
            dfs(nestedList[i]); 
        idx = 0; 
    }
    
    void dfs(NestedInteger cur) {
        if(cur.isInteger() == true) {
            v.push_back(cur.getInteger());
        }
        else {
            vector<NestedInteger> next = cur.getList();
            for(long i = 0; i < next.size(); i++) 
                dfs(next[i]); 
        }
    }
    
    int next() {
        return v[idx++];
    }
    
    bool hasNext() {
        return idx < v.size() ? true : false;
    }
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */
