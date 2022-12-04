class Solution {
public:
    // inclusive 
    static long prefix_sum(vector<long>& pref, int l, int r) {
        return pref[r] - pref[l-1]; 
    }

    int minimumAverageDifference(vector<int>& nums) {
        // iterate through all points with prefix sum 
        vector<long> pref;  // one index 
        long sum = 0; pref.push_back(0); 
        for(int num : nums) pref.push_back( (sum+=num) ); 

        // iterate 
        int ret = INT32_MAX;
        int idx = -1;
        for(int i = 1; i <= nums.size(); i++) {
            int left = floor( prefix_sum(pref, 1, i) / (i) ); 
            int right = (nums.size() - i) == 0 ? 0 : floor( prefix_sum(pref, i+1, nums.size()) / (nums.size() - i) ); 
            if((int)abs(right - left) < ret) {
                ret = (int)abs(right - left); 
                idx = i-1; 
            }
        }
        return idx; 
    }
};
