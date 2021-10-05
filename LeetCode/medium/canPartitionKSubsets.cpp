class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        if(k == 1) return true; 
    
        //determine sum of the whole array 
        int sum = 0;
        for(int item : nums) sum += item; 
        
        //base case
        if(sum%k != 0) return false; //not possible 
        
        vector<bool> visited(nums.size(), false);
        return dfs(nums, visited, 0, k, 0, sum/k); 
        
    }
    
    bool dfs(vector<int>& nums, vector<bool>& visited, int start, int k, int curSum, int target) {
        if(k == 1) return true;
        if(curSum > target) return false;
        if(curSum == target) return dfs(nums, visited, 0, k-1, 0, target);
        for(long i = start; i < nums.size(); i++) {
            if(visited[i] == false) {
                visited[i] = true; 
                if(dfs(nums, visited, i+1, k, curSum+nums[i], target)) return true; 
                visited[i] = false;
            }
        }
        return false; 
    }
};
