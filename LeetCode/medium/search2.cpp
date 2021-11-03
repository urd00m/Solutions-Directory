class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int n = nums.size(); 
        int l = 0; 
        int r = n-1; 
        int mid;
        while(l<=r) { 
            mid = (l+r)/2; 
            
            //found
            if(nums[mid] == target) return true; 
            
            //3 conditions, the pivot is in the left, the pivot is in the right or no pivot detected 
            
            // the right part is unsorted 
            if(nums[mid] > nums[r]) {
                //on the left part
                if(target < nums[mid] && target >= nums[l]) {
                    r = mid-1; 
                }
                else {
                    l = mid+1; 
                }
            }
            //the left part is unsorted 
            else  if(nums[mid] < nums[l]) {
                //on the right part
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid+1; 
                } else {
                    r = mid-1; 
                }
            }
            else if(nums[mid] == nums[l]) l++; 
            else {
                if(nums[mid] < target) {
                    l = mid+1;   
                } 
                else {
                    r = mid-1; 
                }
            }
            
        }
        
        return false; //not found
    }
};
