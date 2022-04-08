class KthLargest {
public:
    vector<int> items; 
    int kth;
    KthLargest(int k, vector<int>& nums) {
        kth = k; 
        items = nums; 
        sort(items.begin(), items.end());
    }
    
    int add(int val) {
        long i = 0; 
        while(i < items.size() && items[i] < val) 
            i++; 
        items.insert(items.begin()+i, val);
        return items[items.size()-kth];
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
