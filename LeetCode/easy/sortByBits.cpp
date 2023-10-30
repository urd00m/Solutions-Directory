class Solution {
public:
    static bool compare(int a, int b) {
        int cnt_a = 0, cnt_b = 0; 
        for(int i = 0; i < 31; i++) {
            if(a & (1<<i)) cnt_a++;
            if(b & (1<<i)) cnt_b++;
        }
        return (cnt_a == cnt_b ? a < b : cnt_a < cnt_b); 
    }
    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), compare);
        return arr; 
    }
};
