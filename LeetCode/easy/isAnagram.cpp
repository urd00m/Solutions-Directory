class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false; 
        vector<int> a = vector(26, 0); 
        vector<int> b = vector(26, 0); 
        for(char c : s) a[c-'a']++; 
        for(char c : t) b[c-'a']++; 
        
        // compare 
        for(long i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false; 
        }
        return true; 
    }
};
