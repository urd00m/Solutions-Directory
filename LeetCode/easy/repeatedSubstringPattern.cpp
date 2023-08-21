class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        //brute force this
        for(int i = 1; i <= s.size()/2; i++) {
            bool match = true;
            string c = s.substr(0, i);
            for(int j = 0; j < s.size(); j += i) {
                if(c != s.substr(j, i)) {
                    match = false; 
                    break; 
                }
            }
            if(match) return true; 
        }
        return false; 
    }
};
