class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ret; 
        
        int start = -12349343, last = -12349343; 
        for(long i = 0; i < nums.size(); i++) {
            if(start == -12349343){
                start = nums[i]; 
            }
            else if(start != -12349343 && last == -12349343) {
                if(nums[i] == start+1) {
                    last = nums[i];
                }
                else {
                    ret.push_back(to_string(start)); 
                    start = nums[i]; 
                }
            }
            else {
                if(nums[i] == last+1) {
                    last = nums[i]; 
                }
                else {
                    ret.push_back("" + to_string(start) +"->" + to_string(last)); 
                    start = nums[i]; 
                    last = -12349343;
                }
            }
        }
        if(start != -12349343 && last != -12349343) {
            ret.push_back("" + to_string(start) +"->" + to_string(last)); 
        }
        else if(start != -12349343 && last == -12349343) {
            ret.push_back(to_string(start)); 
        }
        return ret; 
    }
};
