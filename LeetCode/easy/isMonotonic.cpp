class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        if(nums.size() <= 2) return true; 

        // advance 
        #define INC 1 
        #define DEC 2
        int direction = 0; 
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] == nums[i-1]) continue;
            else if(direction == 0) {
                if(nums[i] > nums[i-1]) direction = INC; 
                else if(nums[i] < nums[i-1]) direction = DEC; 
            }
            else {
                if(direction == INC && nums[i] < nums[i-1]) return false; 
                if(direction == DEC && nums[i] > nums[i-1]) return false; 
            }
        }
        return true; 
    }
};
