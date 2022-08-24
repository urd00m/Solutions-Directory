class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n == 1) return true; 
        if(n == 0) return false; 
        while(true) {
            if(n%3 != 0) break; 
            n /= 3; 
            if(n == 1) return true; 
        }
        return false; 
    }
    
};
