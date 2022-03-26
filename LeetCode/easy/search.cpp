class Solution {
public:
    int search(vector<int>& nums, int target) {
        long l = 0; 
        long r = nums.size()-1;
        
        while(l <= r) {
            long m = (l+r)/2; 
            
            if(nums[m] == target) return m; 
            
            if(nums[m] > target) r = m-1;
            else l = m+1; 
        }
        
        if(l < nums.size() && nums[l] == target) return l;
        else if(r >= 0 && nums[r] == target) return r; 
        else return -1; 
    }
};
