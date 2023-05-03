class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> a, b; 
        for(int item : nums1) a.insert(item);
        for(int item : nums2) b.insert(item);

        // find 
        vector<vector<int>> ret = vector(2, vector(0, 0)); 
        for(int item : a)
            if(b.find(item) == b.end())
                ret[0].push_back(item); 
        for(int item : b)
            if(a.find(item) == a.end())
                ret[1].push_back(item); 
        return ret; 
    }
};
