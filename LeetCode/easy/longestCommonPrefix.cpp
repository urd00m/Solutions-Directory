class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ret = ""; 
        if(strs[0].size() == 0) return ""; 
        
        // determine max size
        long n = 0; 
        for(string& s : strs) if(s.size() > n) n = s.size(); 

        // iterate
        for(int i = 0; i < n; i++) {
            char cur = strs[0][i]; 
            for(string& s : strs) {
                if(s[i] != cur) return ret; 
            }
            ret = ret + cur; 
        }
        
        return ret; 
    }
};
