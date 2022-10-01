class Solution {
public:
    bool isPalindrome(string s) {
        // remove spaces and non alpha numerica 
        string snew;
        snew.reserve(20000); 
        for(int i = 0; i < s.size(); i++) {
            if(!iswalnum(s[i])) continue; 
            snew.push_back(tolower(s[i]));
        }
        
        int l = 0, r = snew.size() -1; 
        while(l < r) {
            if(snew[l] != snew[r]) return false;
            l++; r--; 
        }
        return true; 
    }
};
