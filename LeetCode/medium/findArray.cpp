class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        vector<int> ret; 
        int prev = 0; 
        for(int item : pref) {
            ret.push_back(prev ^ item); 
            prev = item; 
        }
        return ret; 
    }
};
