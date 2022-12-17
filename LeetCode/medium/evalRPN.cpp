class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        // use a stack
        stack<long> s; 
        for(string& str : tokens) {
            if(str.size() != 1 || isdigit(str[0])) 
                s.push(stol(str)); 
            else {
                long op1 = s.top(); s.pop();
                long op2 = s.top(); s.pop();  
                if(str == "/") s.push((long) (op2 / op1) ); 
                else if(str == "*") s.push(op1 * op2); 
                else if(str == "-") s.push(op2 - op1); 
                else s.push(op1 + op2); 
            }
        }
        return (int)s.top(); 
    }
};
