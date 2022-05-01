class Solution {
public:
    bool backspaceCompare(string s, string t) {
        string sFinal = ""; 
        string tFinal = ""; 
        
        for(char c : s) {
            if(c != '#') sFinal += c; 
            else if(sFinal.size() > 0) sFinal.pop_back();
        }
        
        for(char c : t) {
            if(c != '#') tFinal += c; 
            else if(tFinal.size() > 0) tFinal.pop_back();
        }
        
        if(sFinal == tFinal) return true; 
        else return false; 
    }
};
