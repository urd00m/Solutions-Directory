class SmallestInfiniteSet {
public:
    vector<int> set; 
    SmallestInfiniteSet() {
        set = vector(1001, 1); 
    }
    
    int popSmallest() {
        int cur = set[1];
        int idx = 1; 
        while(cur == 0) {
            cur = set[++idx];
        }
        set[idx]=0;
        return idx; 
    }
    
    void addBack(int num) {
        set[num] = 1; 
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */
