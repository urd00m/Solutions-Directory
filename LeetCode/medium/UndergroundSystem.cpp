class UndergroundSystem {
public:
    unordered_map<string, double> total_times;
    unordered_map<string, int> num_times; 
    unordered_map<int, double> id_start;
    unordered_map<int, string> id_station;
    UndergroundSystem() {
        total_times.clear();
        num_times.clear();
        id_start.clear();
        id_station.clear(); 
    }
    
    void checkIn(int id, string stationName, int t) {
        id_start[id] = t; 
        id_station[id] = stationName; 
    }
    
    void checkOut(int id, string stationName, int t) {
        if(total_times.find(id_station[id] + " " + stationName) == total_times.end()) {
            total_times[id_station[id] + " " + stationName] = 0.0; 
            num_times[id_station[id] + " " + stationName] = 0.0; 
        }
        total_times[ (id_station[id] + " " + stationName) ] += t - id_start[id];
        num_times[id_station[id] + " " + stationName]++; 
    }
    
    double getAverageTime(string startStation, string endStation) {
        return total_times[startStation + " " + endStation]/num_times[startStation + " " + endStation];
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */
