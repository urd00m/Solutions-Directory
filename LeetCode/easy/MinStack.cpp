class MinStack {
public:
    int main[10000];
    int min[10000];
    long mainSize = 0;
    long minSize = 0;
    MinStack() {
    }
    
    void push(int val) {
        main[mainSize++] = val; 
        if(minSize == 0 || min[minSize-1] >= val) min[minSize++] = val; 
    }
    
    void pop() {
        if(minSize > 0 && min[minSize-1] == main[mainSize-1]) minSize--; 
        --mainSize; 
    }
    
    int top() {
        return main[mainSize-1]; 
    }
    
    int getMin() {
        //cout << minSize << endl; 
        //if(minSize == 0) return 0;
        return min[minSize-1]; 
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
