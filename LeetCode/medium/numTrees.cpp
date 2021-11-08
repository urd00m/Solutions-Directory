class Solution {
public:
    int numTrees(int n) {
        int build[20]{0};   
        build[0] = 1; build[1] = 1;  
        for(long i = 2; i < 20; i++) {
            
            for(long left = 0; left < i; left++) {
                build[i] += build[left]*build[i-left-1]; 
            }
            
        }
        
        return build[n]; 
    }
};
