class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        vector<int> stack; 
        int pop_idx = 0; 
        for(int item : popped) {
            if(stack.size() == 0 || stack[stack.size()-1] != item) {
                while(pop_idx < pushed.size() && pushed[pop_idx] != item) {
                    stack.push_back(pushed[pop_idx++]); 
                }
                if(pop_idx < pushed.size() && pushed[pop_idx] == item) pop_idx++; 
                else return false; 
            }
            else if (stack[stack.size()-1] == item) {
                stack.pop_back(); 
            }
            
        }
        return true; 
    }
};
