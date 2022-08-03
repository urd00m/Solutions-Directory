class MyCalendar {
public:
    vector<vector<int>> map; 
    MyCalendar() {
        map = vector(0, vector(2, 0)); 
    }
    
    bool book(int start, int end) {
        // check 
        for(vector<int> booking : map) {
            if(start < booking[1] && booking[0] < end) return false; 
        }
        map.push_back({start, end}); 
        return true; 
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */
