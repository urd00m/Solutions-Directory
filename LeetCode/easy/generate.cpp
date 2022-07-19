class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ret; 
        ret.push_back({1});
        for(long i = 1; i < numRows; i++) {
            vector<int> temp; 
            temp.push_back(1);
            for(long j = 1; j < ret[i-1].size(); j++) {
                temp.push_back(ret[i-1][j-1] + ret[i-1][j]);   
            }
            temp.push_back(1); 
            ret.push_back(temp); 
        }
        return ret; 
    }
};
