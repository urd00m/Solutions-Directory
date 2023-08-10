class Solution {
public:
    // check valid 
    bool valid(vector<int>& nums, int t, int p) {
        // count pairs 
        int cnt = 0; 
        for(int i = 0; i < nums.size() - 1; i++) {
            int diff = abs(nums[i+1] - nums[i]); 
            if(diff <= t) {
                cnt++;
                i++; // skip 
            }
        }
        return (cnt >= p);
    }

    int minimizeMax(vector<int>& nums, int p) {
        // always form with immediate neighbor 
        sort(nums.begin(), nums.end()); 

        // bin search plus count 
        int l = 0, r = 1000000000; 
        while(l < r) {
            int m = (l+r)/2; 

            if(valid(nums, m, p)) r = m; 
            else l = m + 1; 
        }
        return l; 
    }
};
