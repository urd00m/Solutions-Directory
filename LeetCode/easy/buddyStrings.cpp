class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if(s.size() != goal.size()) return false; 

        // calc diff
        vector<int> v1 = vector<int>(26, 0); 
        vector<int> v2 = vector<int>(26, 0); 
        int diff = 0; 
        bool d = false; 
        for(int i = 0; i < s.size(); i++) {
            if(s[i] != goal[i]) diff++; 
            if(++v1[s[i] - 'a'] == 2) d = true; 
            v2[goal[i] - 'a']++; 
        }

        // check 
        for(int i = 0; i < 26; i++) 
            if(v1[i] != v2[i]) return false; 
        return (diff == 2 ? true : ((diff == 0 && d) ? true : false)); 
    }
};
