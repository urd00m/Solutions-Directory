string reverseInParentheses(string inputString) {
    stack<string> next; 
    for(size_t i = 0; i < inputString.length(); i++) {
        next.push(string(1, inputString[i])); 
        if(next.top() == ")") { //start removing 
            string temp = "";
            next.pop(); 
            while(next.top() != "(") {
                temp += next.top(); 
                next.pop(); 
            }
            next.pop(); //remove "("
            
            // Re add to the stack
            for(size_t j = 0; j < temp.length(); j++) {
                next.push(string(1, temp[j])); 
            }
        }
    }
    
    //pop all into the string
    string ret = "";
    while(next.empty() == false) {
        ret += next.top();
        next.pop(); 
    }
    
    reverse(ret.begin(), ret.end());
    return ret; 
}

