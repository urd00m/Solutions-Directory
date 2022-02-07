class Solution {
public:
    char findTheDifference(string s, string t) {
        vector<int> a(26, 0);
        vector<int> b(26, 0);
        
        for(char c : s) {
            a[c - 'a']++;
        }
        
        for(char c : t) {
            b[c - 'a']++;
        }
        
        // find the difference
        for(long i = 0; i < 26; i++) {
            if(a[i] != b[i]) return static_cast<char>('a'+i);
        }
        return 'a';  //never be run 
    }
};
