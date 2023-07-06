class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        // iterate through all the subsets? --> 2^16 max 
        // bitmask??? for a leetcode hard wtf?? 
        int ret = 0; 
        int m = requests.size(); 
        vector<int> c = vector(n, 0); 
        for(int i = 0; i < (1<<m); i++) {
            // calculate net 
            int cnt = 0; 
            for(int j = 0; j < m; j++) {
                if(i & (1<<j)) {
                    cnt++; 
                    c[requests[j][0]]--; 
                    c[requests[j][1]]++; 
                }
            }

            // check net 
            bool good = true; 
            for(int j = 0; j < n; j++) {
                if(c[j] != 0) good = false;
                c[j] = 0;
            }
            if(good) ret = max(ret, cnt); 
        }
        return ret; 
    }
};
