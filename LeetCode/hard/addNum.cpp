#define START 0
#define END 1 

class SummaryRanges {
public:
    vector<vector<int>> intervals;
    SummaryRanges() {
        // sorted intervals 
        intervals = vector(0, vector(0, 0)); 
    }
    
    void addNum(int value) {
        // find correct position 
        int i = 0; 
        while(i < intervals.size()) {
            if(i != intervals.size()-1 && intervals[i][END]+1 == value && intervals[i+1][START]-1 == value) {
                intervals[i+1][START] = intervals[i][START];
                intervals.erase(intervals.begin()+i, intervals.begin()+i+1); 
                break; 
            } else if(intervals[i][START]-1 == value) {
                intervals[i][START]--; 
                break; 
            } else if(intervals[i][END]+1 == value) {
                intervals[i][END]++; 
                break; 
            } else if(value >= intervals[i][START] && value <= intervals[i][END]) {
                break; 
            } else if(value < intervals[i][START]){ // standalone 
                intervals.insert(intervals.begin()+i, {value, value}); 
                break; 
            }
            i++; 
        }
        if(i == intervals.size()) {
            intervals.push_back({value, value}); 
        }
    }
    
    vector<vector<int>> getIntervals() {
        return intervals; 
    }
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges* obj = new SummaryRanges();
 * obj->addNum(value);
 * vector<vector<int>> param_2 = obj->getIntervals();
 */
