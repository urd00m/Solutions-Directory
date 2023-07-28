class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        if(batteries.size() < n) return 0; 

        // clearly binary search problem 
        // how do you determine if the given max time works though 
        // assume you sum up the batteries if it is less than the n*time it fails otherwise succeed? 
        // n long n 


        // begin 
        long long l = 1L; 
        long long r = 100000000000000L;
        while(l < r) {
            long long m = (l+r+1)/2; 

            // collect sum 
            long long sum = 0; 
            for(int i : batteries) 
                sum += min((long long)i, m); 

            if(sum < n * m) r = m-1; 
            else l = m; 
        }
        return l; 
    }
};
