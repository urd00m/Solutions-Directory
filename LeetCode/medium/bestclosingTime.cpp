class Solution {
public:
    int bestClosingTime(string customers) {
        // shift and keep track 
        int penalty = 0;
        int min_penalty = 0; 
        int ret = 0; 

        // initialize 
        for(int i = 0; i < customers.size(); i++)
            if(customers[i] == 'Y') penalty++; 
        min_penalty = penalty; 

        // begin shift
        for(int i = 0; i < customers.size(); i++) {
            if(customers[i] == 'Y') penalty--;
            else penalty++; 

            if(penalty < min_penalty) {
                min_penalty = penalty; 
                ret = i+1; 
            }
        }
        return ret; 
    }
};
