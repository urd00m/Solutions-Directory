class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int retl = -1, retr = -1;   
        
        if(nums.size() == 0) return {-1, -1}; 
        //find lower edge of the group 
        long l = 0, r = nums.size()-1;
        while(l < r) {
            int mid = (l+r)/2; 
            
            if(target == nums[mid]) {
                r = mid; 
                continue;
            }
            
            if(target > nums[mid]) {
                l = mid+1;           
            }
            else { //target < nums[mid]
                r = mid-1; 
            }
        }
        
        if(nums[l] != target) {
            return {retl, retr};
        }
        retl = l; 
        
        //find upper edge
        l = 0, r = nums.size()-1;
        while(l < r) {
            int mid = (l+r)/2; 
            
            if(target == nums[mid]) {
                l = mid; 
                if(l+1 < nums.size() && nums[l+1] != target) break; 
                if(l+1 < nums.size() && nums[l+1] == target) l++; 
                continue;
            }
            
            if(target > nums[mid]) {
                l = mid+1;           
            }
            else { //target < nums[mid]
                r = mid-1; 
            }
        }
        retr = l; 
        
        return {retl, retr}; 
    }
};
