class Solution {
public:
    int daysNeeded(vector<int>& weights, int c) {
        int ret = 0; 
        int cur = 0; 
        for(int w : weights) {
            if(w > c) return INT32_MAX; // unable to carry it 
            if(cur+w > c) {
                ret++; 
                cur = 0; 
            }
            cur += w; 
        }
        if(cur > 0) ret++; 
        return ret; 
    }

    int shipWithinDays(vector<int>& weights, int days) {
        // binary search the weight down 
        int l = 1, r = 0; 
        for(int w : weights) r += w; 

        // converge on the weight that is the smallest and gets it done in days 
        while(l < r) {
            int m = (l+r)/2; 
            int days_needed = daysNeeded(weights, m); 

            if(days_needed > days) {
                l = m+1; 
            }
            else if(days_needed <= days) {
                r = m; 
            }
        }
        return l; 
    }
};
