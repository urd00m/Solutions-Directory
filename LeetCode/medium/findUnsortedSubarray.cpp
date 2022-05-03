class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        // sort then determine the bounds 
        vector<int> nums2 = vector(nums); 
        sort(nums2.begin(), nums2.end()); 
        
        // compare 
        long l = -1, r = -1; 
        for(long i = 0; i < nums2.size(); i++) {
            if(nums2[i] != nums[i]) {
                if(l == -1) 
                    l = i; 
                else 
                    r = i; 
            }
        }
        
        if(l == -1) return 0; 
        return r-l+1; 
    }
};
