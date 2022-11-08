class Solution {
public:
    string makeGood(string s) {
        bool first = true; 
        string ret = s; int i;
        while(first || ret.size() != s.size()) {
            if(ret.size() == 0) break; 
            first = false; 
            s = ret; 
            ret = ""; 
            for(i = 0; i < s.size()-1; i++) {
                if( ( (isupper(s[i]) && islower(s[i+1])) || (islower(s[i]) && isupper(s[i+1])) ) && tolower(s[i]) == tolower(s[i+1])) i++; 
                else ret += string(1, s[i]);
            }
            if(i == s.size() - 1) ret += string(1, s[i]);
        }
        return ret; 
    }
};
