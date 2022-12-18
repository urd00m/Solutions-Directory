class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size(); 
        vector<int> ret = vector(n, 0);  
        vector<int> max_temp_idx = vector(101, -1); 
        max_temp_idx[temperatures[n-1]] = n-1; 

        // go backwards and record max temperatures 
        for(int i = n-2; i >= 0; i--) {
            int cur_temp = temperatures[i]; 

            // scan for higher temperature 
            int min_dist = INT32_MAX;
            for(int t = cur_temp + 1; t < 101; t++) 
                if(max_temp_idx[t] != -1) min_dist = min(min_dist, max_temp_idx[t] - i); 
            if(min_dist == INT32_MAX) ret[i] = 0;  
            else ret[i] = min_dist; 
            max_temp_idx[cur_temp] = i; 
        }

        return ret; 
    }
};
