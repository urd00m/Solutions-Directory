class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        // s is of size N, words is of size M 
        // store indexes in ascending order of s characters O(N)
        // then check to see if word characters exist O(M)
        // total time O(N+M)
        
        // preprocess character mapping of index 
        vector<vector<int>> map = vector(26, vector(0, 0));
        for(long i = 0; i < s.size(); i++)
            map[s[i]-'a'].push_back(i); 
        
        // go through words 
        int ret = 0; 
        for(string& word : words) {
            long prev = -1;  
            for(char c : word) {
                auto cur = upper_bound(map[c-'a'].begin(), map[c-'a'].end(), prev); 
                if(cur == map[c-'a'].end()) {
                    ret--; 
                    break; 
                }
                prev = map[c-'a'][cur - map[c-'a'].begin()]; 
            }
            ret++; 
        }
        return ret; 
    }
};
