class MyHashSet {
public:
    vector<bool> hashset; 
    MyHashSet() {
        hashset = vector<bool>(1000001, false); 
    }
    
    void add(int key) {
        hashset[key] = true; 
    }
    
    void remove(int key) {
        hashset[key] = false; 
    }
    
    bool contains(int key) {
        return hashset[key]; 
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
