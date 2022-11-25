#define MOD 1000000007
class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        // monotonic stack 
        // with dp 
        size_t n = arr.size(); 
        vector<int> dp = vector(n, 0); 
        stack<int> s;
        for(int i = 0; i < n; i++) {
            // remove all values greater than the current position, stack is monotonically increasing 
            while(!s.empty() && arr[s.top()] > arr[i]) s.pop(); 

            // get leftmost position
            int l = !s.empty() ? s.top() : -1; 

            // add to dp
            dp[i] = ((i - l) * arr[i]) % MOD;  // right portion 
            dp[i] = (dp[i] + (l==-1 ? 0 : dp[l])) % MOD;
            
            s.push(i); 
        }

        // sum it all up
        int ret = 0; 
        for(int val : dp) 
            ret = (ret + val) % MOD; 
        return ret; 
    }
};
