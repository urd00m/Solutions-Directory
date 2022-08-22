class Solution {
    public boolean isPowerOfFour(int n) {
        // play with bits 
        while(n > 0) {
            if(n == 1) return true;
            if( ((n & 1) == 1 || (n & 2) == 2) && n > 1) return false; 
            n = n >> 2; // divide by 4 
        }
        return false; 
    }
} 
