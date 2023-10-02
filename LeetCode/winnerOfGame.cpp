class Solution {
public:
    bool winnerOfGame(string colors) {
        // count blob sizes 
        int cntA = 0, cntB = 0; 
        
        // count a
        int cnt = 0;
        for(char c : colors) {
            if(c == 'A') {
                if(++cnt >= 3) cntA++; 
            }
            else 
                cnt = 0; 
        }
        cnt = 0;
        for(char c : colors) {
            if(c == 'B') {
                if(++cnt >= 3) cntB++; 
            }
            else 
                cnt = 0; 
        }

        // ret
        return (cntA > cntB); 
    }
};
