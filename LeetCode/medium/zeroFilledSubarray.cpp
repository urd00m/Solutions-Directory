class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        // count consecutive zeros and add 
        long long ret = 0; 
        long long zeros = 0; 
        for(int n : nums) {
            if(n == 0) zeros++; 
            else {
                ret += ((long long)zeros * ((long long)zeros+1L))/2L;
                zeros = 0; 
            }
        }
        ret += ((long long)zeros * ((long long)zeros+1L))/2L;
        return ret; 
    }
};
