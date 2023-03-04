#define NONE 0 
#define MIN 1 
#define MAX 2 
#define BOTH 3

/*
  1 3 5 2 1 5 
0 0 1 0 1 0
0 1 1 0 0 2
0 0 0 2 2 0 
0 0 0 1 1 3
ret = 5
*/

class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        // dp 
        // you can split the array into sections based on elements outside the range of values given then just run a simple check among those to see how many subarrays you can have 
        long long ret = 0; 

        // one index dp 
        long n = nums.size(); 
        vector<vector<int>> dp = vector(n+1, vector(4, 0)); 
        for(int i = 1; i < n+1; i++) {
            if(nums[i-1] < minK || maxK < nums[i-1]) continue; // zero out values 

            // increment dp
            if(nums[i-1] == minK && nums[i-1] != maxK) {
                dp[i][MIN]++;
                dp[i][BOTH] += dp[i-1][MAX]; 
                dp[i][MIN] += dp[i-1][MIN];
                dp[i][MIN] += dp[i-1][NONE]; 
                dp[i][BOTH] += dp[i-1][BOTH];
            }
            else if(nums[i-1] == maxK && nums[i-1] != minK) {
                dp[i][MAX]++; 
                dp[i][BOTH] += dp[i-1][MIN]; 
                dp[i][MAX] += dp[i-1][MAX];
                dp[i][MAX] += dp[i-1][NONE]; 
                dp[i][BOTH] += dp[i-1][BOTH];
            }
            else if(nums[i-1] != maxK && nums[i-1] != minK) {
                dp[i][NONE]++;
                dp[i][NONE] += dp[i-1][NONE]; 
                dp[i][MAX] += dp[i-1][MAX];
                dp[i][MIN] += dp[i-1][MIN]; 
                dp[i][BOTH] += dp[i-1][BOTH]; 
            }
            else { // equal to both 
                dp[i][BOTH]++;
                dp[i][BOTH] += dp[i-1][BOTH]; 
                dp[i][BOTH] += dp[i-1][NONE]; 
            }
            ret += dp[i][BOTH]; 
        }

        return ret; 
    }
};
