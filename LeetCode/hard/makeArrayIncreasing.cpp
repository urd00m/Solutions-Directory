class Solution {
public:
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        // O(N^2) algorithm dp 
        // states -> [pos, prev] O(n^2) states * bin search (upper_bound) update
        sort(arr2.begin(), arr2.end()); 

        // set up dp 
        vector<unordered_map<int,int>> dp = vector(arr1.size()+1, unordered_map<int,int>()); // store [ prev, dp val ]
        dp[0][INT32_MIN] = 0; 

        // begin dp 
        for(int i = 1; i <= arr1.size(); i++) {
            for( auto& [prev, dpval] : dp[i-1] ) {
                if(arr1[i-1] > prev) dp[i][arr1[i-1]] = dp[i].find(arr1[i-1]) != dp[i].end() ? min(dp[i][arr1[i-1]], dpval) : dpval; 
            
                // find replacement 
                int n = upper_bound(arr2.begin(), arr2.end(), prev) - arr2.begin(); 
                if(n < arr2.size()) 
                        dp[i][arr2[n]] = dp[i].find(arr2[n]) != dp[i].end() ? min(dp[i][arr2[n]], dpval+1) : dpval+1;
                
            }
        }

        // return 
        int ret = -1; 
        for(auto& [key, val] : dp[arr1.size()]) {
            ret = (ret == -1 ? val : min(ret, val)); 
        }
        return ret; 
    }
};
