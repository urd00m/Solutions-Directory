class Solution {
public:
    int bulbSwitch(int n) {
        if(n == 0 || n == 1) return n; 
        // find the number of values with odd number of factors 
        // specifically only the squares of numbers have odd factors
        return sqrt(n); 
    }
};
