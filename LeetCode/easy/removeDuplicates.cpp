class Solution {
public:
    string removeDuplicates(string s) {
        // stack (parenthesis trick) 
        stack<char> stck; 
        for(char c : s) {
            if(!stck.empty() && c == stck.top()) 
                stck.pop(); 
            else 
                stck.push(c); 
        }

        // create string 
        string ret = ""; 
        while(!stck.empty()) {
            ret += string(1, stck.top()); 
            stck.pop(); 
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
