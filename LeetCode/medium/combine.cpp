class Solution {
public:
    vector<vector<int>> ret; 
    vector<vector<int>> combine(int n, int k) {
        vector<int> temp(0);
        recur(1, n, k, temp); 
        return Solution::ret; 
    }

    void recur(int i, int n, int k, vector<int>& cur) {
        if(cur.size() == k) Solution::ret.push_back(cur); 
        else {
            for(int j = i; j <= n; j++) {
                cur.push_back(j);
                recur(j+1, n, k, cur);
                cur.pop_back(); 
            }
        }
    }

    
    /*
    vector<vector<int>> ret; 
    vector<vector<int>> combine(int n, int k) {
        vector<int> used(n+1, 0); 
        vector<int> temp(0); 
        dfs(n, k, temp, used); 
        return Solution::ret; 
    }
    
    void dfs(int n, int k, vector<int>& cur, vector<int>& used) {
        if(cur.size() == k) Solution::ret.push_back(cur);
        else {
            for(int i = 1; i <= n; i++) {
                if(used[i] == 1) continue; 
                cur.push_back(i);
                used[i] = 1; 
                dfs(n, k, cur, used); 
                used[i] = 0;
                cur.pop_back(); 
            }
        }
    }
    */
};
