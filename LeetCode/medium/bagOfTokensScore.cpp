class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
       // greedy
        sort(tokens.begin(), tokens.end());  // sort ascending order 
        
        // then just iterate till you can't no more 
        int score = 0;
        int ret = 0; 
        bool changed = true; 
        int l = 0; int r = tokens.size()-1; 
        while(changed && l <= r) {
            changed = false;
            if(power >= tokens[l]) {
                score++;
                power -= tokens[l++]; 
                changed = true; 
            }
            else if(power < tokens[l] && score >= 1) {
                score--;
                power += tokens[r--]; 
                changed = true; 
            }
                
            ret = max(ret, score); 
        }
        
        return ret; 
    }
};
