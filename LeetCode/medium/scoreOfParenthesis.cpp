class Solution {
public:
    int scoreOfParentheses(string p1) {
        
        // -1 == (  -2 == )
        int ret = 0; 
        
        stack<int> s; 
        for(char item : p1) {
            if(item != ')') {
                if(item != '(') s.push(item); 
                else s.push(-1);
            }
            else {
                // find -1 in the stack 
                int sum = 0; 
                while(s.top() != -1) {
                    sum += s.top(); s.pop(); 
                }
                if(sum == 0) sum = 1; 
                else sum *= 2; 
                s.pop(); //remove ( 
                s.push(sum); 
            }
        }
        
        while(s.empty() == false) {
            ret += s.top(); s.pop(); 
        }
        
        return ret; 
    }
};
