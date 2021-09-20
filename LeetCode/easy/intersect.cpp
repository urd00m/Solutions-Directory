class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int exists[1001] = {0}; 
        for(unsigned long i = 0; i < nums1.size(); i++) {
            exists[nums1[i]]++; 
        }
        
        //check
        vector<int> ret; 
        for(unsigned long i = 0; i < nums2.size(); i++) {
            if(exists[nums2[i]]) {
                ret.push_back(nums2[i]);
                exists[nums2[i]]--;
            }
        }
        
        return ret; 
    }
};
