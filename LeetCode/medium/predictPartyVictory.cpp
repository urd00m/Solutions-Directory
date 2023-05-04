class Solution {
public:
    string predictPartyVictory(string senate) {
        size_t n = senate.size(); 
        vector<int> banned = vector(n, 0); 
        int r = 0, d = 0;
        int ban_r = 0, ban_d = 0; 

        for(char c : senate) 
            if(c == 'R') r++; 
            else d++; 

        if(r == 0) return "Dire";
        else if(d == 0) return "Radiant"; 

        // always ban the closest senator 
        while(true) {
            for(int i = 0; i < n; i++) {
                char c = senate[i]; 

                // lost rights already 
                if(banned[i]) continue; // already banned 
                if(ban_r && c == 'R') {
                    banned[i] = 1; 
                    ban_r--;
                    continue; 
                } else if(ban_d && c == 'D') {
                    banned[i] = 1; 
                    ban_d--;
                    continue; 
                }

                // has rights 
                if(c == 'R') {
                    ban_d++; 
                    d--; 
                    if(d == 0) return "Radiant";
                }
                else {
                    ban_r++; 
                    r--; 
                    if(r == 0) return "Dire";
                }
            }
        }
        return "Bruh"; 
    }
};
