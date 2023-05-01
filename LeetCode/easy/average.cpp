class Solution {
public:
    double average(vector<int>& salary) {
        int sum = 0; 
        int l = INT32_MAX, r = INT32_MIN; 
        for(int item : salary) {
            sum += item; 
            l = min(l, item); 
            r = max(r, item); 
        }
        return ((double)sum - l - r)/((double)salary.size()-2.0);
    }
};
