class Solution {
public:
    int partitionString(string s) {
        // greedy 
        int ret = 0; 
        vector<int> v = vector(26, 0); 
        for(char c : s) {
            if(v[c - 'a']) {
                ret++; 
                v = vector(26, 0); 
            }
            v[c - 'a'] = 1; 
        }
        for(int i = 0; i < 26; i++)
            if(v[i]) {
                ret++;
                break; 
            } 
        return ret; 
    }
};
