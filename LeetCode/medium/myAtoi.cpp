class Solution {
public:
    int myAtoi(string s) {
        long ret = 0; long multiplier = 1; 
        bool first = true; 
        for(unsigned long i = 0; i < s.length(); i++) {
            if(s[i] == ' ' && first == true) continue; 
            if((s[i] -'0' > 9 || s[i]-'0' < 0) && (s[i] != '-' || first == false) && (s[i] != '+' || first == false)) break; //we are done 
            else {
                if(first == true && s[i] == '-') {
                    multiplier = -1; 
                }                
                else if(first == true && s[i] == '+') {
                    multiplier = 1; 
                }
                else {
                    ret = ret*10 + (s[i]-'0'); 
                }
                
                if(ret*multiplier > INT_MAX) {
                    ret = INT_MAX; 
                    break; 
                }
                else if(ret*multiplier < INT_MIN) {
                    ret = INT_MIN;
                    break; 
                }
                first = false; 
            }
        }
        return ret*multiplier; 
    } 
};
