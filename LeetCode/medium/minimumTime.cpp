class Solution {
public:
    static long long get_trips(vector<int>& time, long long t) {
        long long ret = 0; 
        for(int item : time) 
            ret += t/item;
        return ret;
    }

    long long minimumTime(vector<int>& time, int totalTrips) {
        // binary search the sucker
        long long l = 0; 
        long long r = 100000000000000L;
        while(l < r) {
            long long m = (l+r)/2; 
            long long trips = get_trips(time, m); 
            if(trips < totalTrips) 
                l = m + 1; 
            else 
                r = m; 
        }
        return l; 
    }
};
