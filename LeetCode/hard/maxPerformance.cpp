#define MOD 1000000007

class Solution {
public:
    
    static bool compare(pair<int,int>& a, pair<int,int>& b) {
        if(a.second == b.second) return a.first > b.first; 
        else return a.second > b.second;
    }
    
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        // combine both arrays to sort 
        vector<pair<int,int>> engineers; 
        for(int i = 0; i < n; i++) 
            engineers.push_back({speed[i], efficiency[i]}); 
        
        // sort by efficiency in descending order  
        sort(engineers.begin(), engineers.end(), compare); 
        
        // need to maintain speed information (heap / priority queue)
        priority_queue<int, vector<int>, greater<int>> pq; 
        int pq_size = 0;
        long speed_sum = 0; 
        long ret = 0; 
        for(int i = 0; i < n; i++) {
            // this engineer is base 
            long eff = engineers[i].second; 
            long speed = engineers[i].first;
            
            if(pq_size >= k) {
                speed_sum -= pq.top(); pq.pop(); pq_size--; 
            }
            pq_size++;
            speed_sum += speed; 
            pq.push(speed);
            
            // add team 
            ret = max(ret, speed_sum*eff); 
        }
        
        return ret%MOD; 
    }
};
