class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        // edge case check 
        int max1 = INT32_MIN, min1 = INT32_MAX;
        int max2 = INT32_MIN, min2 = INT32_MAX;
        for(int item : nums1) {
            max1 = max(max1, item);
            min1 = min(min1, item); 
        }
        for(int item : nums2) {
            max2 = max(max2, item); 
            min2 = min(min2, item); 
        }
        if(max1 < 0 && min2 > 0) return max1 * min2; 
        if(min1 > 0 && max2 < 0) return min1 * max2; 

        // dp 
        // i j -> max product from 0..i to 0..j exclusive 
        // transition: either take i and j (product and add) or skip i or j 
        int n = nums1.size(); 
        int m = nums2.size(); 
        vector<vector<int>> dp = vector(n + 1, vector(m + 1, INT32_MIN)); 
        dp[0][0] = 0; 

        // begin dp 
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i < n && j < m) dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j] + (nums1[i] * nums2[j])); 
                if(i < n) dp[i+1][j] = max(dp[i+1][j], dp[i][j]); 
                if(j < m) dp[i][j+1] = max(dp[i][j+1], dp[i][j]); 
            }
        }

        return dp[n][m]; 
    }
};
