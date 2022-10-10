class Solution {
public:
    string breakPalindrome(string palindrome) {
        if(palindrome.size() == 1) return ""; 
        
        // find first a 
        string ret = palindrome; 
        for(int i = 0; i < ret.size(); i++) {
            if(ret.size()%2 && i == ret.size()/2) continue; 
            if(ret[i] != 'a') {
                ret[i] = 'a'; 
                return ret; 
            }
        }
        ret[ret.size()-1] = 'b';
        return ret; 
    }
};
