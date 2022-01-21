class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        //calculate dif and add 
        int net = 0; 
        int current = 0; 
        int start = 0;
        
        for(long i = 0; i < gas.size(); i++) {
            int diff = gas[i]-cost[i]; 
            net += diff; 
            current += diff; 
            if(current < 0) {
                start = i+1; 
                current = 0; 
            }
        }
        if(net < 0) return -1; //not possible 
        
        //if it is possible 
        return start; 
        
    }
};
