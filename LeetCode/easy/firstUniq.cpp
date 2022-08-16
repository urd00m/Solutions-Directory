class Solution {
public:
    int firstUniqChar(string s) {
        // get character counts
        vector<int> counts = vector(26, 0); 
        for(char c : s) counts[c - 'a']++; 
        
        // iterate 
        for(int i = 0; i < s.size(); i++)  {
            if(counts[s[i] - 'a'] == 1) return i;
        }
        
        return -1; 
    }
};

// took < 1 minute
