class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> charCount(26, 0); 
        for(char c : p) {
            charCount[c-'a']++; 
        }
        
        // slide and count 
        vector<int> ret; 
        if(p.length() > s.length()) return ret; 
        char start = '-'; 
        vector<int> curCount(26, 0); 
        for(long i = 0; i < p.length()-1; i++) curCount[s[i]-'a']++; 
        for(long i = 0; i < s.length()-p.length()+1; i++) {
            if(start != '-') {
                curCount[start-'a']--; 
            }
            start = s[i]; 
            curCount[s[i+p.length()-1] - 'a']++; 
            if(compare(curCount, charCount)) ret.push_back(i); 
        }
        
        return ret; 
    }
    
    bool compare(vector<int> a, vector<int> b) {
        for(long i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false; 
        }
        return true; 
    }
};
