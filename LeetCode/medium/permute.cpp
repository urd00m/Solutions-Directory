class Solution {
public:
    vector<bool> used; 
    vector<vector<int>> ret;
    int n;
    vector<vector<int>> permute(vector<int>& nums) {
        Solution::used = vector<bool>(nums.size(), false); 
        Solution::n = nums.size(); 
        vector<int> temp; 
        recur(nums, temp, 0); 
        return Solution::ret; 
    }
    
    void recur(vector<int>& nums, vector<int>& cur, int depth) {
        if(depth == Solution::n) Solution::ret.push_back(cur);
        cur.push_back(-1); 
        for(long i = 0; i < Solution::n; i++) {
            if(Solution::used[i] == true) continue;
            Solution::used[i] = true; 
            cur[depth] = nums[i]; 
            recur(nums, cur, depth+1);
            cur[depth] = -1;
            Solution::used[i] = false; 
        }
        cur.pop_back(); 
    }
};
