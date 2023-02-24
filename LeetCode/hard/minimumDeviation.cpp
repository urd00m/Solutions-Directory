class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        if(nums.size() == 1) return 0; 

        // make all even
        int minval = INT32_MAX;
        priority_queue<int> pq; 
        for(int n : nums) {
            if(n % 2 == 1) {
                pq.push(n*2);
                minval = min(minval, n*2);
            }
            else {
                pq.push(n);
                minval = min(minval, n);
            }
        }

        // find deviation
        int ret = INT32_MAX;
        while(true) {
            int cur = pq.top(); pq.pop(); 

            // calculate best 
            ret = min(ret, cur - minval);

            // this is the max possible value 
            if(cur % 2 == 1) break; 

            // divide by 2 
            minval = min(minval, cur/2); 
            pq.push(cur/2); 
        }

        return ret; 
    }
};
