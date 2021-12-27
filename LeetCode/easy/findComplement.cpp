class Solution {
public:
    int findComplement(int num) {
        unsigned int ret = 0; 
        unsigned int a = num; 
        bool hit = false; 
        for(int i = 30; i >= 0; i--) {
            if(hit && (a & 1<<i) == 0) {
                ret += 1<<i; 
            }
            if(hit == false && (a & 1<<i) != 0) {
                hit = true; 
            }
        }
        
        return ret; 
    }
};
