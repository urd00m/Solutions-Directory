class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        //check through 
        int cur = INT32_MIN; 
        int count = 0;
        for(long i = 0; i < nums.size(); i++) {
            if(count == 2 && nums[i] == cur) nums[i] = INT32_MIN; //mark for deletion 
            else if(nums[i] == cur) count++;
            else {
                count = 1;
                cur = nums[i]; 
            }
        }
        
        return squash(nums);
    }
    
    int squash(vector<int>& nums) {
        //checks for any sort of spaces (we wil lbe using INT32_MIN to denote deletion)
        vector<int> copy;
        for(int item : nums) if(item != INT32_MIN) copy.push_back(item); //only push nondeleted items 
        
        //copy it over 
        long i = 0;
        for(; i < copy.size(); i++) {
            nums[i] = copy[i];
        }
        
        return copy.size(); 
    }
};
