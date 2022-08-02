class Solution {
public:
    bool isSubsequence(string s, string t) {
        long j = 0; 
        for(long i = 0; i < t.size(); i++) {
            if(j == s.size()) return true; 
            if(s[j] == t[i]) j++;
        }
        if(j == s.size()) return true; 
        return false; 
    }
};	
