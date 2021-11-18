class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int hit[200000]{0}; 
        for(int item : nums) hit[item]++; 
        vector<int> ret; 
        for(long i = 1; i <= nums.size(); i++) {
            if(hit[i] == 0) ret.push_back(i);
        }
        return ret; 
    }
};
