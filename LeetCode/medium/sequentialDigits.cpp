class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> start = {12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        vector<int> increment = {11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};
        
        vector<int> ret; 
        for(long i = 0; i < start.size(); i++) {
            int cur = start[i];
            int inc = increment[i];
            while(cur%10 != 0) {
                if(cur >= low && cur <= high) {
                    ret.push_back(cur); 
                }
                cur += inc; 
            }
        }
        
        return ret; 
    }
};
