class Solution {
// Best memory usage barely any new memory used 
// Beat 32.54 of c++ submissions
// Faster solution is to find the first decreasing element, then find the one just larger of it and swap them and then reverse the array (it would be in descending order we need ascending)
public:
    void nextPermutation(vector<int>& nums) {
        for(long i = nums.size()-2; i >= 0; i--) {
            //search for a bigger element 
            bool isSwapped = false; 
            for(long j = i+1; j < nums.size(); j++) {
                if(nums[i] < nums[j]) {
                    //perform a swap 
                    swap(nums, i, j); //we are done 
                    isSwapped = true;
                    break; 
                }
            }
            if(isSwapped) break; 
            append(nums, i); //nums[i] is the biggest element so move to the back 
        }
    }
    
    //swaps the value at l and r 
    void swap(vector<int>& nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp; 
    }
    
    //moves an item to the back of the list 
    void append(vector<int>& nums, int item_loc) {
        int save = nums[item_loc]; 
        for(long i = item_loc; i < nums.size()-1; i++) {
            nums[i] = nums[i+1];
        }
        nums[nums.size()-1] = save; 
    }
};
