class Solution {
public:
    bool reorderedPowerOf2(int n) {
        long cur = 1; 
        string a = to_string(n); 
        vector<int> num = vector(26, 0); 
        for(char c : a) num[c -'0']++;
        
        // go up powers of 2 
        while(cur < 1000000000) {
            string cur_s = to_string(cur); 
            vector<int> cur_c = vector(26, 0); 
            for(char c : cur_s) cur_c[c-'0']++; 
            
            // can we make this 
            bool possible = true; 
            for(int i = 0; i < 26; i++)
                if(cur_c[i] != num[i]) {
                    possible = false;
                    break; 
                }
            
            if(possible) return true; 
            cur = cur<<1; 
        }
        return false; 
    }
};
