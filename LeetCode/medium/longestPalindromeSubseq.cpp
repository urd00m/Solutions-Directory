class Solution {
public:
    int longestPalindromeSubseq(string s) {
        long n = s.size(); 
        
        // dp 
        // dp[i] = the max palindrome seen from i ... n-1 
        // state update O(n) total time O(n^2) 
        // go through 0.. i-1 if any match current char, we then update the place it matches 
        
        vector<int> dp = vector(n, 1); 
        for(long i = 0; i < n; i++) {
            int add = 0; 
            for(long j = i-1; j >= 0; j--) { 
                int update = max(add, dp[j]); // we don't want to containmenate from using the new dp[j], because if we were to find one down the line we can't use the current i position 
                if(s[j] == s[i]) {        
                    dp[j] = max(dp[j], 2+add);  // this is key you need to update the furthest left point that way we know there is no overlap 
                }
                add = update; // running max 
            }
        }
        
        // find max 
        int ret = 1; 
        for(int item : dp)
            ret = max(ret, item); 
        return ret; 
    }
    
    
    // n x p j g y m m j y
    // 1 1 1 4 1 4 2 1 1 1
    
    // q v s e a a z z b z s l
    // 1 1 5 1 2 1 3 1 1 1 1 1
    
    // q v s e a a z z b z s l
    // l s z b z z a a e s v q
    // 1 1 3 1 2 1 2 1 1 5 1 1 
    
};
