#define MOD 1000000007

class Solution {
public:
    int countHomogenous(string s) {
        // just count 
        int ret = 0; 
        int cnt = 0; 
        char cur = '\0'; 
        for(char c : s) 
            if(c == cur) ret = (ret + ++cnt)%MOD; 
            else {
                cur = c; 
                cnt = 1; 
                ret += cnt; 
            }
        return ret; 
    }
};
