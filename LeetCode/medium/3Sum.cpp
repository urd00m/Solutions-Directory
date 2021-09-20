class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end()); //sort
        
        vector<vector<int>> ret;
        if(nums.size() < 3) return ret; //base case
        if(nums[0] > 0) return ret; //base case
        
        // algorithm
        int exists[300000] = {0}; //to find index of negative numbers do i+10000
        
        //fill
        for(unsigned long i = 0; i < nums.size(); ++i) {
            exists[nums.at(i)+100000] = i;
        }
        
        for(unsigned long i = 0; i < nums.size(); ++i) {
            if(nums[i] > 0) break;
            for(unsigned long j = i+1; j < nums.size(); ++j) {
                int index_of_sum = -1*(nums.at(i) + nums.at(j))+100000; //number we want to find
                if(index_of_sum < 0 || index_of_sum >= 300000) continue;
                if(exists[index_of_sum] && exists[index_of_sum] > j) {
                    ret.push_back({nums.at(i), nums.at(j), index_of_sum-100000});
                }
                j = exists[nums[j]+100000];
            }
            i = exists[nums[i]+100000];
        }
        
        return ret;
    }
};
