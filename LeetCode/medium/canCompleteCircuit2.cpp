class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        // calculate the difference 
        // keep running sum 
        // 6 1  4  3  5
        // 3 8  2  4  2 
        // 3 -7 2  -1 3
        // 3 -4 -2 -3 0
        int sum = 0; 
        int ret = -1; 
        int positive = -1; 
        int running_sum = 0; 

        // iteration 
        for(int i = 0; i < cost.size(); i++) {
            bool neg = sum < 0; 
            int diff = gas[i] - cost[i]; 
            sum += diff; running_sum += diff; 

            // determine index 
            if(positive == -1 && running_sum >= 0) positive = i; 
            else if(running_sum < 0) positive = -1; 

            // running sum to determine idx 
            if(running_sum < 0) running_sum = 0; 

            // set 
            if(sum >= 0 && positive != -1) ret = positive; 
            else if(sum < 0) ret = -1; 
        }

        return ret; 
    }
};
