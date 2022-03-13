class Solution {
public:
    bool isValid(string s) {
        stack<char> myStack; 
        unordered_map<char, char> convert; 
        convert[')'] = '(';
        convert['}'] = '{';
        convert[']'] = '[';
        for(char c : s) {
            if(c == ')' || c == '}' || c == ']') {
                bool found = false; 
                while(myStack.empty() == false) {
                    char cur = myStack.top(); myStack.pop(); // top char 
                    if(cur == convert[c]) {
                        found = true; 
                        break; 
                    }
                    else if(cur == '(' || cur == '{' || cur == '[') return false; 
                }
                if(found == false) return false; 
            }
            else {
                myStack.push(c);
            }
        }
        
        //scan 
        while(myStack.empty() == false) {
            char cur = myStack.top(); myStack.pop();
            if(cur == '(' || cur == '{' || cur == '[') return false; 
        }
        return true;
    }
};
