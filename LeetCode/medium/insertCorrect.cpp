class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        
        
        vector<vector<int>> ret; 
        long i = 0;
        
        //Add those that won't overlap 
        while(i < intervals.size() && intervals[i][1] < newInterval[0]) {
            ret.push_back(intervals[i]); 
            i++;
        }
        
        //Anything that is overlapping would be here 
        vector<int> overlap = newInterval; 
        while(i < intervals.size() && intervals[i][0] <= overlap[1]) {
            overlap[0] = min(overlap[0], intervals[i][0]); 
            overlap[1] = max(overlap[1], intervals[i][1]); 
            i++; 
        }
        ret.push_back(overlap);
        
        //Add the rest
        while(i < intervals.size()) {
            ret.push_back(intervals[i]);
            i++;
        }
        
        return ret; 
    }
};
