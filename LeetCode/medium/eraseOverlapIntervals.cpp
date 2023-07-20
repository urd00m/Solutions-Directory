class Solution {
public:
    static bool compare(vector<int>& a, vector<int>& b) {
        return a[1] < b[1]; 
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        // greedy use the ending time 
        // this algorithm can be proved to be correct
        sort(intervals.begin(), intervals.end(), compare); 

        // begin 
        int ret = 0; 
        int prev = INT32_MIN; 
        for(vector<int>& c : intervals) {
            if(c[0] >= prev) prev = c[1]; 
            else ret++; 
        }
        return ret; 
    }
};
