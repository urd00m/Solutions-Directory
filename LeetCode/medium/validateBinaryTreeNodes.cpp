class Solution {
public:
    bool recur(int cur, vector<int>& leftChild, vector<int>& rightChild, vector<int>& v) {
        if(cur == -1) return true; 
        if(v[cur]) return false; 
        v[cur] = 1; 
        return recur(leftChild[cur], leftChild, rightChild, v) && recur(rightChild[cur], leftChild, rightChild, v);
    }

    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        // check if you visit a node twice 
        vector<int> v = vector(n, 0); 

        // determine sources 
        vector<int> in = vector(n, 0); 
        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1) in[leftChild[i]]++; 
            if(rightChild[i] != -1) in[rightChild[i]]++;           
        }
        vector<int> src; 
        for(int i = 0; i < n; i++) 
            if(!in[i])
                src.push_back(i);
        if(src.size() != 1) return false; 

        bool ret = recur(src[0], leftChild, rightChild, v);
        for(int c : v) 
            if(c == 0) return false;
        return ret; 
    }
};
