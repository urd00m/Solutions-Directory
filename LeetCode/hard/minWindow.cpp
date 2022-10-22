class Solution {
public:
    string minWindow(string s, string t) {
        // two pointers 
        long l = 0; 
        long r = 0; 
        
        // set up vector of what remains 
        long remaining = t.size(); 
        vector<int> true_char = vector(58, 0);
        for(char c : t) true_char[c - 'A']++; 
        for(int i = 0; i < 58; i++) true_char[i] = true_char[i] ? true_char[i] : -1; 
        vector<int> exist_char = vector(58, 0); // chars we have
        
        // begin iteration 
        int min_size = INT32_MAX; long lret = -1; long rret = -1; 
        while(r < s.size()+1) {
            // check if all met 
            if(remaining == 0) {
                // check for min 
                if(min_size > (r-l)) {
                    min_size = r - l; 
                    lret = l; 
                    rret = r; 
                }
                
                // see if we can decrease size
                if(l < r) {
                    if(true_char[s[l] - 'A'] >= exist_char[s[l] - 'A']) remaining++; // we lose an important one
                    exist_char[s[l] - 'A']--; 
                    l++;
                }
                else break; // found size 0 
            }
            else if(r < s.size()) {
                // add new item 
                if(exist_char[s[r] - 'A'] < true_char[s[r] - 'A']) remaining--; 
                exist_char[s[r] - 'A']++; 
                r++;
            }  
            else break; 
        }
        
        if(lret == -1) return ""; 
        return s.substr(lret, min_size);
    }
};
