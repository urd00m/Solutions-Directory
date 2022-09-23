#define MOD 1000000007

class Solution {
public:
    int concatenatedBinary(int n) {
        if(n == 1) return 1; 
        
        // should be O(n)
        int msb = 0; 
        long ret = 0; 
        for(int i = 1; i <= n; i++) {
            if(i & (1<<(msb+1))) msb++; 
            ret = ret << (msb+1); // shift so we can add new one
            ret += i;
            ret = ret%MOD;
        }
        
        return ret; 
    }
};
