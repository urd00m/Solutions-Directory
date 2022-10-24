class Solution {
public:
    
    int maxLength(vector<string>& arr) {
        map<int, int> ans; 
        vector<vector<int>> words = vector(0, vector(0, 0)); 
        
        // fill 
        for(string word : arr) {
            int mask = 0; 
            bool fine = true; 
            for(int i = 0; i < word.size(); i++) {
                if(mask & 1<<(word[i] - 'a')) {
                    fine = false;
                    break;
                }
                mask |= 1<<(word[i] - 'a'); 
            }
            if(fine) words.push_back({mask, (int)word.size()}); 
        }
                
        // dp 
        int ret = 0; 
        ans[0] = 0; 
        for(vector<int> a : words) {
            int mask = a[0]; int val = a[1]; 
            for(auto const& [key, value] : ans) {
                if((mask & key) == 0) {
                    ans[mask + key] = val + value; 
                    ret = max(ret, val + value); 
                }
            }
        }
        
        return ret; 
    }
};
