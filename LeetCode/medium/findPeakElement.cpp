class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        // binary search 
        long l = 0, r = nums.size()-1;
        
        while(l < r) {
            int mid = (l+r)/2; 
            int left = mid-1 >= 0 ? nums[mid-1] : INT32_MIN; 
            int right = mid+1 < nums.size() ? nums[mid+1] : INT32_MAX; 
            //cout << mid << " " << left << " " << right << endl; 
            
            if(nums[mid] > left && nums[mid] > right) return mid;
            else if(nums[mid] >= left && nums[mid] < right) l = mid+1; 
            else r = mid-1; 
        }
        
        return l;
    }
};
