class Solution {
public:
    string removeStars(string s) {
        // add to stack and pop as needed 
        stack<char> q; 
        for(char c : s) {
            if(c == '*') q.pop(); 
            else q.push(c);
        }

        // pop 
        string ret = ""; 
        while(!q.empty()) {
            ret += string(1, q.top()); 
            q.pop(); 
        }
        reverse(ret.begin(), ret.end());
        return ret; 
    }
};
