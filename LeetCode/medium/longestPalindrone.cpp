class Solution {
public:
    string longestPalindrome(string s) {
        for(int i = s.length(); i>= 2; i--) { 
            for(int j = 0; j < s.length()-i+1; j++) {
                
                //check palindrone
                int l = j; int r = j+i-1; 
                bool match = true; 
                while(l <= r) {
                    if(s[l] != s[r]) {
                        match = false;
                        break; 
                    }
                    l++; r--; 
                }
                if(match) { //we are palindrone 
                    return s.substr(j, i); 
                }
                
            }
        }
        if(s.length() >= 1) return s.substr(0, 1); 
        else return "";
        
    }
};
