class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size(); 
        vector<int> res(n, 0);
        for(long i = n-2; i >= 0; i--) {
            int j = i+1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] > 0) j = res[j] + j;
                else j = n;
            }
            if (j < n) res[i] = j - i;
        }
        return res; 
    }
};
