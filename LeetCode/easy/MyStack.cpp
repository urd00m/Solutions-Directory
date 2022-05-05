class MyStack {
public:
    vector<int> mystack; 
    MyStack() {
        mystack = vector<int>(0); 
    }
    
    void push(int x) {
        mystack.push_back(x); 
    }
    
    int pop() {
        int ret = mystack[mystack.size()-1]; 
        mystack.pop_back(); 
        return ret; 
    }
    
    int top() {
        return mystack[mystack.size()-1];
    }
    
    bool empty() {
        return mystack.size() == 0 ? true : false; 
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
