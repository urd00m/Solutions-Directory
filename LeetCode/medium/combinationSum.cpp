class Solution {
public:
    vector<vector<int>> ret; 
    long n; 
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        Solution::n = candidates.size(); 
        vector<int> temp;
        dfs(temp, target, 0, candidates);
        return ret;
    }
    
    void dfs(vector<int> &cur, int target, long idx, vector<int> &candidates) {
        if(target == 0) {
            Solution::ret.push_back(cur); 
        } else if(idx != Solution::n && target > 0) {
            int tempTarget = target; 
            tempTarget -= candidates[idx];
            int count = 0; 
            while(tempTarget >= 0) {
                count++;
                cur.push_back(candidates[idx]);
                dfs(cur, tempTarget, idx+1, candidates);
                tempTarget -= candidates[idx];
            }
            for(int i = 0; i < count; i++) //remove any items added 
                cur.pop_back(); 
            
            //skip this item
            dfs(cur, target, idx+1, candidates);
        } 
    }
};
