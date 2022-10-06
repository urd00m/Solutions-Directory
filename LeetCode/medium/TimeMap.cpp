class TimeMap {
public:
    unordered_map<string, vector<pair<int, string>>> ds; 
    TimeMap() {
        ds.clear(); 
    }
    
    void set(string key, string value, int timestamp) {
        if(ds.find(key) == ds.end()) 
            ds[key] = vector<pair<int, string>>(0, make_pair(-1, ""));
        ds[key].push_back(make_pair(timestamp, value)); 
    }
    
    string get(string key, int timestamp) {
        if(ds.find(key) == ds.end()) return ""; 
        vector<pair<int, string>>& times = ds[key]; 
        
        // binary search 
        int l = 0; int r = times.size()-1; 
        while(l < r) {
            int mid = (l+r)/2; 
            
            if(times[mid].first == timestamp) return times[mid].second; 
            
            if(times[mid].first > timestamp) r = mid - 1; 
            else l = mid + 1; 
        }
        if(times[l].first <= timestamp) return times[l].second;
        else if(l-1 >= 0 && times[l-1].first <= timestamp) return times[l-1].second;
        else return "";
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
