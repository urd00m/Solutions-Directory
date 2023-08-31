class Solution {
public:
    static bool compare(vector<int>& a, vector<int>& b) {
        if(a[0] != b[0]) return a[0] < b[0];
        else return a[1] > b[1];
    }

    int minTaps(int n, vector<int>& ranges) {
        // sort + greedy 
        // craft intervals
        vector<vector<int>> intervals = vector(0, vector(0, 0)); 
        for(int i = 0; i <= n; i++) {
            if(ranges[i] == 0) continue; 
            intervals.push_back({i - ranges[i], i + ranges[i]});
        }
        sort(intervals.begin(), intervals.end(), compare); 

        // greedy 
        // take interval that covers the current point but has the rightmost index
        int ret = 0; 
        int covered = 0; 
        for(int i = 0; i < intervals.size(); i++) {
            // already been covered 
            if(intervals[i][1] <= covered) continue;
            
            // select right most interval that includes covered 
            int sel = -1; 
            int j; 
            for(j = i; j < intervals.size(); j++)
                if(intervals[j][0] <= covered && covered <= intervals[j][1] && (sel == -1 || intervals[sel][1] < intervals[j][1])) 
                    sel = j; 
                else if(covered < intervals[j][0]) break; 
            if(sel == -1) return -1; 
            else {
                covered = intervals[sel][1];   
                ret++;
                i = j-1;
            }
            if(covered >= n) break; 
        }
        if(covered < n) return -1;
        else return ret; 
    }
};
