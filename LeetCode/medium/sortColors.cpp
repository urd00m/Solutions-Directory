class Solution {
public:
    void sortColors(vector<int>& nums) {
        int bins[3]{0}; 
        for(int item : nums) {
            bins[item]++;
        }
        long cur = 0; 
        for(long i = 0; i < nums.size(); i++) {
            while(bins[cur] == 0) cur++; 
            nums[i] = cur; bins[cur]--; 
        }
    }
};
//finished in 2 minute
