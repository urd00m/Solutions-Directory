class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        // two pointers sliding window 
        size_t n = answerKey.size(); 
        size_t l = 0; 
        size_t r = 0; 
        int tc = 0; int fc = 0; 
        int ret = 0; 
        while(l <= r) { 
            if(r == n) {
                if(min(tc, fc) <= k) ret = max((int)(r-l), ret); 
                break;    
            }

            if(min(tc, fc) > k) {
                if(answerKey[l] == 'T') tc--;
                else fc--; 
                l++;
            }
            else {
                ret = max((int)(r-l), ret); 
                if(answerKey[r] == 'T') tc++;
                else fc++; 
                r++; 

            }            
        }
        return ret; 
    }
};
