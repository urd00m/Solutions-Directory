class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        sort(nums.begin(), nums.end()); 
        unordered_map<int, int> exists; 
        vector<vector<int>> ret; 
        
        for(unsigned long i = 0; i < nums.size(); i++) {
            exists[nums[i]] = i; //last position 
        }
        
        //go Through the list 
        for(unsigned long i = 0; i < nums.size(); i++) {
            if(static_cast<long>(nums[i]) * 4 > target || target > nums.back() * 4) break; //optimization, reduces the time by a factor of 10
            for(unsigned long j = i+1; j < nums.size(); j++) {
                if(static_cast<long>(nums[j]) * 3 > (target-nums[i]) || (target-nums[i]) > nums.back() * 3) break; //optimization reduces the time by a factor of 10
                for(unsigned long k = j+1; k < nums.size(); k++) { 
                    int needs = target - (nums[i] + nums[j] + nums[k]); 
                    if(exists[needs] <= k) continue; 
                    ret.push_back({needs, nums[k], nums[j], nums[i]});
                    k = exists[nums[k]]; 
                }
                j = exists[nums[j]]; 
            }
            i = exists[nums[i]];
        }
        
        return ret; 
    }
};
