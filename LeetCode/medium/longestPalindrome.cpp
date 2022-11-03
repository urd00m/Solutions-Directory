class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        // store maps of all characters 
        int pairs = 0;
        unordered_map<string, int> count; 
        
        // update 
        for(string& s : words) {
            if(count.find(s) == count.end()) count[s] = 0; 
            
            // find other pair 
            string rs = s; reverse(rs.begin(), rs.end()); 
            if(count.find(rs) != count.end() && count[rs] >= 1) {
                pairs++; 
                count[rs]--; 
            }
            else count[s]++; 
        }
        
        // find if any center piece leftovers exist 
        int center = 0;
        for(int i = 0; i < 26; i++) {
            string search = string() + (char)(i + 'a') + (char)(i + 'a'); 
            if(count.find(search) != count.end() && count[search] == 1) center = 2; 
        }
        
        return center + pairs*4; 
    }
};
