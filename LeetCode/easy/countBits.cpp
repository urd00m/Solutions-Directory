class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> ret; 
        
        for(int num = 0; num <= n; num++) {
            int count = 0; 
            for(int i = 0; i < 32; i++) {
                if(num & 1<<i) {
                    count++;
                }
            }
            ret.push_back(count);
        }
        
        return ret; 
    }
};
