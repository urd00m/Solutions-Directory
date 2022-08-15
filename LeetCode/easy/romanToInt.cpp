class Solution {
public:
    int romanToInt(string s) {
        int ret = 0; 
        for(long i = 0; i < s.size(); i++) {
            if(s[i] == 'M') ret += 1000;
            if(s[i] == 'D') ret += 500; 
            if(s[i] == 'L') ret += 50; 
            if(s[i] == 'V') ret += 5; 
            if( s[i] == 'I' && (i+1 >= s.size() || (s[i+1] != 'V' && s[i+1] != 'X')) ) ret += 1; 
            else if( s[i] == 'I' && (i+1 < s.size() && s[i+1] == 'V') ) {
                ret += 4;
                i++; 
                continue; 
            }
            else if( s[i] == 'I' && (i+1 < s.size() && s[i+1] == 'X') ) {
                ret += 9;
                i++; 
                continue; 
            }
            if( s[i] == 'X' && (i+1 >= s.size() || (s[i+1] != 'L' && s[i+1] != 'C')) ) ret += 10; 
            else if( s[i] == 'X' && (i+1 < s.size() && s[i+1] == 'L') ) {
                ret += 40;
                i++; 
                continue; 
            }
            else if( s[i] == 'X' && (i+1 < s.size() && s[i+1] == 'C') ) {
                ret += 90;
                i++; 
                continue; 
            }
            if( s[i] == 'C' && (i+1 >= s.size() || (s[i+1] != 'D' && s[i+1] != 'M')) ) ret += 100; 
            else if( s[i] == 'C' && (i+1 < s.size() && s[i+1] == 'D') ) {
                ret += 400;
                i++; 
                continue; 
            }
            else if( s[i] == 'C' && (i+1 < s.size() && s[i+1] == 'M') ) {
                ret += 900;
                i++; 
                continue; 
            }
        }
        
        return ret; 
    }
};
