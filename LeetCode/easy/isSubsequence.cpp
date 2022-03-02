class Solution {
public:
    bool isSubsequence(string s, string t) {
        
        size_t t_counter = 0; 
        size_t i = 0; 
        while(true) {
            if(i >= s.length()) 
                break; 
            
            while(t_counter < t.length()) {
                if(t[t_counter++] == s[i]) {
                    i++; 
                    break; 
                }
            }
            
            if(t_counter == t.length()) 
                break; 
        }
        
        if(i == s.length()) {
            return true; 
        }
        return false; 
     }
};
