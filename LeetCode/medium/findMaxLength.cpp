class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        //prefix sum 
        unordered_map<int, int> prev; 
        prev[0] = -1; 
        int sum = 0; int max = 0;
        for(long i = 0; i < nums.size(); i++) {
            sum += (nums[i] == 0) ? -1 : 1; 
            if(prev.find(sum) == prev.end()) { //not found 
                prev[sum] = i;
            }
            else {
                int dist = i - prev[sum];
                if(dist > max) max = dist; 
            }
        }
        
        return max; 
    }
};
