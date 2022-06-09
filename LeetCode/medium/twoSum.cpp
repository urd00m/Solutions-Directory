class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        // two pointers 
        int l = 0, r = numbers.size()-1; 
        while(l < r) {
            if(numbers[l]+numbers[r] == target) return {l+1, r+1}; 
            
            if(numbers[l]+numbers[r] < target) l++;
            else r--; 
        }
        
        return {-1, -1}; 
    }
};
