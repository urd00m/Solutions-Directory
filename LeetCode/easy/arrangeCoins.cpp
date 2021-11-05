class Solution {
public:
    int arrangeCoins(int n) {
        if(n == 0) return 0;
        return static_cast<int>(-.5 + sqrt(.25+2.0*n) );
    }
};
