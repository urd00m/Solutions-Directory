class Solution {
public:
    int minFlips(int a, int b, int c) {
        int ret = 0; 
        for(int i = 0; i <= 30; i++) {
            int ac = a & (1<<i); 
            int bc = b & (1<<i); 
            int cc = c & (1<<i); 
            if(cc == 0) 
                ret += (ac == 0 ? 0 : 1) + (bc == 0 ? 0 : 1); 
            else 
                ret += ((ac | bc) > 0 ? 0 : 1); 
            
        }
        return ret; 
    }
};

// 101111100000
// 110
// 101
