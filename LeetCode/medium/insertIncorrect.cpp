class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        long i = 0; 
        
        //looking for start time overlaps
        int startIdx = -1; 
        int newStart = newInterval[0];
        int newEnd = newInterval[1]; 
        vector<vector<int>> ret; 
        //see if it overlaps with the first one 
        if(intervals.size() > 0 && newEnd >= intervals[0][0] && newEnd <= intervals[0][1]) {
            startIdx = newStart; 
            newEnd = intervals[0][1]; 
            i++; 
        }
        for(; i < intervals.size(); i++) {
            int start = intervals[i][0];
            int end = intervals[i][1]; 
            if(startIdx == -1 && start <= newStart && newStart <= end) { //begin contain 
                startIdx = start; 
                newEnd = max(end, newEnd); //the new end is whatever is max 
            }
            else if(startIdx != -1 && start > newEnd) { //exit 
                ret.push_back({startIdx, newEnd}); 
                startIdx = -2; 
                break; 
            }
            else if(startIdx != -1) { //stil contained 
                newEnd = max(newEnd, end); 
            }
            else { //just regular 
                ret.push_back(intervals[i]); 
            }
        }
        //if just one interval aftwards 
        if(i == intervals.size() && (startIdx != -1 && startIdx != -2)) {
            ret.push_back({startIdx, newEnd}); 
            return ret; 
        }
        if(i == intervals.size() && startIdx == -1) { //not overlapping 
            //find when we should insert
            long j = 0;
            for(; j < intervals.size(); j++) {
                if(intervals[j][0] > newInterval[0]) break; 
            }
            auto temp = ret.insert(ret.begin()+j, newInterval); 
            return ret; 
        }
        
        //add the rest of the intervals 
        for(; i < intervals.size(); i++) 
            ret.push_back(intervals[i]);
        
        return ret; 
    }
};
