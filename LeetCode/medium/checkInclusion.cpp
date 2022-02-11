class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()) return false; 
        
        //preprocess 
        vector<int> s1map(26, 0);
        for(char c : s1) {
            s1map[c-'a']++; 
        }
        
        // Iterate thorugh s2 
        for(long j = 0; j <= s2.length() - s1.length(); j++) {
            vector<int> substringmap(26, 0);
            for(long i = 0; i < s1.length(); i++) {
                substringmap[s2[i+j] - 'a']++;
            }
            if(match(s1map, substringmap)) return true; 
        }
        
        return false; //not possible 
    }
    
    bool match(vector<int> a, vector<int> b) {
        for(long i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
};
