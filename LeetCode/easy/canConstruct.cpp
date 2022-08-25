class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> r = vector(26, 0); 
        vector<int> m = vector(26, 0); 
        for(char c : ransomNote) r[c - 'a']++;
        for(char c : magazine) m[c - 'a']++;
        
        // count 
        for(int i = 0; i < 26; i++) {
            if(m[i] < r[i]) return false;
        }
        
        return true; 
    }
};
