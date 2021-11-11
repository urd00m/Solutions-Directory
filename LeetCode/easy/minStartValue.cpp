class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int min = INT32_MAX;
        int count = 0; 
        for(int item : nums) {
            count += item; 
            if(count < min) min = count; 
        }
        
        if(min >= 1) return 1;
        else return (-1*min)+1;
    }
};
