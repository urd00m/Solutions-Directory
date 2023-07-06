class Solution {
public:
    int recur(int cookie, int k, vector<int>& cookies, vector<int>& kids) {
        if(cookie == cookies.size()) {
            int ans = 0; 
            for(int item : kids) ans = max(ans, item); 
            return ans; 
        }

        // determine which cookies go to with backtracking 
        int ret = INT32_MAX;
        for(int i = 0; i < k; i++) {
            kids[i] += cookies[cookie];
            ret = min(ret, recur(cookie+1, k, cookies, kids));
            kids[i] -= cookies[cookie];
        }
        return ret; 
    }

    int distributeCookies(vector<int>& cookies, int k) {
        // iterate possible combinations 
        vector<int> kids = vector(k, 0);
        return recur(0, k, cookies, kids); 
    }
};
