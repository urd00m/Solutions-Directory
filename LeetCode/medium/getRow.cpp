class Solution {
public:
    vector<int> getRow(int rowIndex) {
        if(rowIndex == 0) return {1};
        vector<int> ret;
        vector<int> prev = vector(rowIndex+1, 0); 
        prev[0] = 1; 
        for(long i = 1; i <= rowIndex; i++) { 
            ret = vector(rowIndex+1, 0); 
            ret[0] = 1; 
            for(long j = 1; j < i; j++) {
                ret[j] = prev[j-1]+prev[j]; 
            }
            ret[i] = 1; 
            prev = ret; 
        }
        return ret; 
    }
};
