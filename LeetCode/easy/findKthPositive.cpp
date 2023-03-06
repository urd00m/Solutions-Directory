class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        vector<int> d = vector(3001, 0); 
        for(int item : arr) d[item] = 1; 
        int i = 1; 
        while(k > 0) if(!d[i++]) k--; 
        return i-1; 
    }
};
