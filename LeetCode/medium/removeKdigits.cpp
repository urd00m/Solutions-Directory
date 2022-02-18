class Solution {
public:
    string removeKdigits(string num, int k) {
        long n = num.length();
        if(n <= k) return "0"; 
        
        stack<char> s;
        
        // go through num 
        for(char& c : num) {
            while(!s.empty() && s.top() > c && k != 0) {
                s.pop();
                k--; 
            }
            s.push(c); 
        }
        
        //remove last elements if there are k left\
        if(s.size() <= k) return "0"; 
        while(!s.empty() && k != 0) {
            s.pop(); 
            k--; 
        }
        
        //retrieve items 
        string temp = "";
        while(!s.empty()) {
            temp += s.top();
            s.pop(); 
        }
        reverse(temp.begin(), temp.end());
        
        //remove leading zeroes 
        long i = 0;
        for(i = 0; i < temp.length(); i++) {
            if(temp[i] != '0') break; 
        }
        string ret = temp.substr(i, temp.size());
        if(ret.size() == 0) return "0";
        return ret; 
        
    }
};
