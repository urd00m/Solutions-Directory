class Solution {
public:
    vector<int> dp; //memoization 
    //top down 
    bool canJump(vector<int>& nums) {
        Solution::dp = vector(nums.size(), 2); //0 false, 1 true, 2 not visited 
        return dfs(nums, 0); 
    }
    
    bool dfs(vector<int>& nums, int idx) {
        //base case 
        if(idx == nums.size()-1) //at the end 
            return true; 
        if(idx >= nums.size() || nums[idx] == 0) //out of bounds or stalled 
            return false;
        
        //memoization
        if(Solution::dp[idx] != 2)
            return Solution::dp[idx] == 0 ? false : true; 
        
        //iterate 
        int maxJump = nums[idx]; 
        bool answer = false; 
        for(int i = maxJump; i >= 1; i--) { //start with the maxJump
            answer = answer || dfs(nums, idx+i); 
            if(answer == true) break; 
        }
        
        //for memoization 
        Solution::dp[idx] = (answer == false ? 0 : 1); 
        
        return answer; 
    }
};
