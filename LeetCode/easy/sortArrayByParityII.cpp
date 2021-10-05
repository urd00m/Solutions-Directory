class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        //sort the array based on odd and evens 
        vector<int> evens;
        vector<int> odds;
        for(int item : nums) {
            if(item%2==0) {
                evens.push_back(item);
            }
            else {
                odds.push_back(item);
            }
        }
        
        //sort each array
        //sort(evens.begin(), evens.end());
        //sort(odds.begin(), odds.end()); 
        vector<int> ret(nums.size(), -1);
        //re-add to the nums 
        int j = 0; 
        for(int i = 0; i < nums.size(); i+=2) {
            ret[i] = evens[j]; 
            j++; 
        }
        j = 0; 
        for(int i = 1; i < nums.size(); i+=2) {
            ret[i] = odds[j]; 
            j++; 
        }
        
        return ret; 
    }
};
