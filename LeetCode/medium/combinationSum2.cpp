class Solution {
public:
    vector<vector<int>> ret; 
    unordered_map<string, bool> contains; 
    long n; 
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        Solution::n = candidates.size(); 
        vector<int> temp;
        dfs(temp, target, 0, candidates);
        return ret;
    }
    
    void dfs(vector<int> &cur, int target, long idx, vector<int> &candidates) {
        if(target == 0 && Solution::contains.find(convert(cur)) == Solution::contains.end()) {
            Solution::ret.push_back(cur); 
            Solution::contains[convert(cur)] = true; 
        } else if(idx != Solution::n && target > 0) {
            //can only use it once 
            cur.push_back(candidates[idx]);
            //long offset = 1; 
            //while(candidates[idx+offset] == candidates[idx]) {
            //    offset++; 
            //}
            dfs(cur, target-candidates[idx], idx+1, candidates);
            cur.pop_back(); 
            //skip this item
            long offset = 1; 
            while(idx+offset < Solution::n && candidates[idx+offset] == candidates[idx]) {
                offset++; 
            }
            if(idx+offset != Solution::n)
                dfs(cur, target, idx+offset, candidates);
        } 
    }
    
    string convert(vector<int> a) {
        string ret = "";
        for(int item : a) {
            ret += to_string(item) + " "; 
        }
        return ret; 
    }
};
