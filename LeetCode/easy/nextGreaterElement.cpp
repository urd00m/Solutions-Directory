class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int loc[10005]{-1}; 
        for(long i = 0; i < nums2.size(); i++) {
            loc[nums2[i]] = i; 
        }
        
        //for each element in nums1 find the location in nums2 then find the next greater element
        vector<int> ret; 
        for(long i = 0; i < nums1.size(); i++) {
            long j = loc[nums1[i]]+1; 
            for(; j < nums2.size(); j++) {
                if(nums2[j] > nums1[i]) {
                    ret.push_back(nums2[j]);
                    break;
                }
            }
            if(j == nums2.size()) ret.push_back(-1);
        }
        
        return ret; 
    }
};
