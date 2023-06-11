class SnapshotArray {
public: 
    map<vector<int>, int> m; 
    int snapid; 
    vector<int> last_changed; 

    SnapshotArray(int length) {
        last_changed = vector(length, -1);
        snapid = 0; 
        m.clear();
    }
    
    void set(int index, int val) {
        m[{snapid, index}] = val; 
        last_changed[index] = snapid; 
    }
    
    int snap() {
        return snapid++;
    }
    
    int get(int index, int snap_id) {
        if(last_changed[index] < snap_id) return m[{last_changed[index], index}]; 
        for(int i = snap_id; i >= 0; i--)
            if(m.find({i, index}) != m.end())
                return m[{i, index}];
        return 0; 
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */
