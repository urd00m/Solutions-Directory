class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        vector<vector<int>> ret; 
        long j = 0; long i = 0; 
        while(i < firstList.size() && j < secondList.size()) {
            int startMax = max(firstList[i][0], secondList[j][0]);
            int endMin = min(firstList[i][1], secondList[j][1]); 
            
            if(endMin >= startMax) {
                ret.push_back({startMax, endMin}); 
            }
            
            if(endMin == firstList[i][1]) i++;
            else j++;
        }
        return ret; 
    }
};
