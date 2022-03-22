class Solution {
public:
    string getSmallestString(int n, int k) {
        // greedy 
        int rem = k; 
        string ret = ""; 
        for(int i = 1; i <= n; i++) {
            int addon = (rem-(n-i) <= 26 ? (rem-(n-i) - 1) : 25);
            char temp = 'a'+ addon;
            rem -= (addon+1);
            ret += temp; 
        }
        reverse(ret.begin(), ret.end());
        return ret; 
    }
};
