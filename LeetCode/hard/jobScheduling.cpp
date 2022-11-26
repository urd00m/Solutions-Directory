class Solution {
public:
    static bool compare(vector<int>& a, vector<int>& b) {
        if(a[0] != b[0]) return a[0] < b[0] ? true : false; 
        else if(a[1] != b[1]) return a[1] < b[1] ? true : false; 
        else return a[2] >= b[2] ? true : false; 
    }

    static int find_idx(vector<vector<int>>& jobs, int time) {
        int l = 0, r = jobs.size()-1; 
        while(l < r) {
            int mid = (l+r)/2; 

            if(jobs[mid][0] < time) l = mid+1; 
            else if(jobs[mid][0] > time) r = mid; 
            else r = mid; 
        }
        return jobs[l][0] < time ? -1 : l; 
    }

    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        long n = startTime.size(); 
        vector<vector<int>> jobs; 
        for(long i = 0; i < n; i++) 
            jobs.push_back({startTime[i], endTime[i], profit[i]}); 

        // sort 
        sort(jobs.begin(), jobs.end(), compare); 

        // dp by job index (using bineary search ) (add additional index at the end for out of bounds)
        // maintain previous max 
        vector<int> dp = vector(n+1, 0); 
        int prev_max = 0; 
        for(int i = 0; i < n; i++) {
            vector<int>& cur_job = jobs[i]; 

            // set max 
            prev_max = max(prev_max, dp[i]); 

            // take it or not 
            int found_idx = find_idx(jobs, cur_job[1]); 
            int next_idx = found_idx == -1 ? n : found_idx;
            dp[next_idx] = max(dp[next_idx], cur_job[2] + prev_max); 
        }

        // find max profit
        int ret = 0;  
        for(int val : dp) 
            ret = max(ret, val);

        return ret; 
    }
};
