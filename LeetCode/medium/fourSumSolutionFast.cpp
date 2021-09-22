class Solution {
public: // 8 times faster, half the memory, the twoSum is just significantly faster then the hashmap solutions. 
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(begin(nums), end(nums));
        return kSum(nums, target, 0, 4);
    }
	
    vector<vector<int>> kSum(vector<int>& nums, int target, int start, int k) {
        vector<vector<int>> res;
        if (start == nums.size() || static_cast<long>(nums[start]) * k > target || target > nums.back() * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
    
        for (int i = start; i < nums.size(); ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (vector<int>& subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.push_back({nums[i]});
                    res.back().insert(end(res.back()), begin(subset), end(subset));
                }
                                            
        return res;
    }
	
    vector<vector<int>> twoSum(vector<int>& nums, int target, int start) {
        vector<vector<int>> res;
        int lo = start, hi = nums.size() - 1;
    
        while (lo < hi) {
            int curr_sum = nums[lo] + nums[hi];
            if (curr_sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (curr_sum > target || (hi < nums.size() - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.push_back({ nums[lo++], nums[hi--] });
        }
                                                           
        return res;
    }
};
