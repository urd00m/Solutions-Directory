class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int max = 0; 
        for(vector<int> a : accounts) {
            int total = sum(a);
            if(total > max) max = total; 
        }
        return max; 
    }
    
    int sum(vector<int> a) {
        int sum = 0; 
        for(int item : a) {
            sum += item;    
        }
        return sum; 
    }
};
