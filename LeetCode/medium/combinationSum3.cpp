class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ret; 
        vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        //try all subsets with the correct size
        int mask;
        for(mask = 0; mask < (1<<9); mask++) {
            int size = 0; 
            int sum = 0;
            vector<int> temp;
            for(int i = 0; i < 9; i++) 
                if(mask&(1<<i)) {
                    size++; 
                    sum += nums[i]; 
                    temp.push_back(nums[i]);
                }
            
            if(size != k) continue; 
            if(sum == n) ret.push_back(temp);
        }
        
        return ret; 
    }
};
