class MyHashMap {
public:
    vector<int> keyvalue; 
    MyHashMap() {
        keyvalue = vector(1000001, -1);
    }
    
    void put(int key, int value) {
        keyvalue[key] = value; 
    }
    
    int get(int key) {
        return keyvalue[key];
    }
    
    void remove(int key) {
        keyvalue[key] = -1; 
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
