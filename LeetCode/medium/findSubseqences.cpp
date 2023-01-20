class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        // bit mask brute force 
        // with map for duplicates
        vector<vector<int>> ret; 
        map<vector<int>, int> m; 

        // brute force
        int n = nums.size(); 
        for(int mask = 0; mask < (1<<n); mask++) {
            vector<int> cur_sub; 
            int cur_el = -101; 
            bool valid = true; 
            for(int i = 0; i < n; i++) {
                if((1<<i) & mask) {
                    if(nums[i] >= cur_el) {
                        cur_el=nums[i]; 
                        cur_sub.push_back(cur_el); 
                    }
                    else {
                        valid = false;
                        break; 
                    }
                }
            }

            if(valid && cur_sub.size() >= 2 && m.find(cur_sub) == m.end()) {
                ret.push_back(cur_sub);
                m[cur_sub] = 1; 
            }
        }

        return ret; 
    }
};
