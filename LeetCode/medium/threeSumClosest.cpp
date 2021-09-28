class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        //sort the array 
        sort(nums.begin(), nums.end());
        
        int closestSum = INT_MIN; 
        //then choose one to start 
        for(long i = 0; i < nums.size(); i++) {
            
            //go through and find a sum that works
            long l = 0, r = nums.size()-1; 
            while(l < r) {
                if(l == i) {
                    l++; continue;
                }
                if(r == i) {
                    r--; continue; 
                }
                                    
                //cur sum 
                int cur_sum = nums[l] + nums[r] + nums[i]; 
                
                //calculate distance from target 
                if(closestSum == INT_MIN || abs(target - closestSum) > abs(target - cur_sum)) {
                    closestSum = cur_sum; 
                    //optimizations 
                    if(target == cur_sum) break; //perfect match 
                }
                
                
                //attempt to get closer 
                if(cur_sum > target) {
                    r--; //too big 
                }
                else {
                    l++; //too small
                }
            }
        }
        return closestSum;
    }
};
