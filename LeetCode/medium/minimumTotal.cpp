class Solution {
public:
    vector<vector<int>> dp;
    int max_depth; 
    int minimumTotal(vector<vector<int>>& triangle) {
        //dfs with memoization 
        Solution::dp = vector(200, vector(200, INT32_MAX)); 
        Solution::max_depth = triangle.size()-1; 
        return recur(triangle, 0, 0);
    }
    
    int recur(vector<vector<int>>& triangle, int depth, int pos) {
        if(depth == max_depth) 
            return triangle[depth][pos]; 
        
        if(Solution::dp[depth][pos] != INT32_MAX)
            return Solution::dp[depth][pos]; 
        
        int mincost = min(recur(triangle, depth+1, pos), recur(triangle, depth+1, pos+1));
        Solution::dp[depth][pos] = min(Solution::dp[depth][pos], mincost + triangle[depth][pos]);
        return mincost + triangle[depth][pos]; 
    }
    
    
};
