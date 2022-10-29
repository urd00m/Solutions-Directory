class Solution {
public:
    static bool compare(pair<int, int>& p1, pair<int, int>& p2) {
        // sort descending for grow time
        return (p1.second > p2.second); 
    }
    
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        // construct pair 
        size_t n = plantTime.size(); 
        vector<pair<int,int>> times; 
        for(size_t i = 0; i < n; i++) 
            times.push_back(make_pair(plantTime[i], growTime[i])); 
        
        // sort
        sort(times.begin(), times.end(), compare); 
        
        // calculate max time
        int ret = 0;
        int prevPlantTimes = 0; 
        for(pair<int, int>& time : times) {
            prevPlantTimes += time.first; 
            ret = max(ret, prevPlantTimes + time.second); 
        }
        return ret; 
    }
};
