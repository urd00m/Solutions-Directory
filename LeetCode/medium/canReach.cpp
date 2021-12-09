class Solution {
public:
    vector<int> dp; 
    long n; 
    bool canReach(vector<int>& arr, int start) {
        n = arr.size(); 
        dp = vector(n, 0); 
        return recur(start, arr); 
    }
    
    bool recur(long cur, vector<int>& arr) {
        if(cur >= Solution::n || cur < 0) return false; 
        else if(arr[cur] == 0) {
            Solution::dp[cur] = 1; 
            return true; 
        }
        else if(Solution::dp[cur] != 0) return Solution::dp[cur] == 1 ? true : false; 
        
        Solution::dp[cur] = 2; //set to visited basically 
        bool answer = recur(cur + arr[cur], arr) || recur(cur - arr[cur], arr); 
        Solution::dp[cur] = answer ? 1 : 2; 
        return answer; 
    }
};

//Less than 10 minutes for algorithm creation and completion of top down dp recursive algorithm with memoization 
