class Solution {
public:
    vector<int> dp; //memoization 
    //top down 
    bool canJump(vector<int>& nums) {
        int i = 0; 
        int reach = 0;
        if(nums.size() == 1 || nums.size() == 0) return true;
        for(; i < nums.size() && i <= reach; i++) {
            reach = max(i+nums[i], reach);
            if(reach >= nums.size()-1) return true; 
        }
        return false; 
    }
    
  
};

/*
// other implementation
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxjump = -1;
        for(int i = 0; (i < nums.size() && (i <= maxjump || maxjump == -1)); i++) {
            int cur = nums[i] + i; 
            maxjump = max(maxjump, cur); 
            if(maxjump >= nums.size()-1) return true; 
        }
        return false; 
    }
};

*/
