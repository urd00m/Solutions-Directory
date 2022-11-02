class Solution {
public:
    bool valid_mutation(string& a, string& b) {
        int count = 0; 
        for(int i = 0; i < a.size(); i++) 
            if(a[i] != b[i]) count++; 
        
        return (count <= 1);
    }
    
    int minMutation(string start, string end, vector<string>& bank) {
        // the ending string must be in bank
        int end_string_loc = -1; 
        for(int i = 0; i < bank.size(); i++) if(bank[i] == end) end_string_loc = i; 
        if(end_string_loc == -1) return -1; 
        
        // dp 
        unordered_map<string, int> dp; dp[start] = 0; 
        queue<string> next; 
        next.push(start); 
        while(!next.empty()) {
            string& cur = next.front(); next.pop(); 
        
            // valid mutation and hasn't been traversed yet 
            for(string& s : bank) {
                if(valid_mutation(cur, s) && dp.find(s) == dp.end()) { 
                    dp[s] = dp[cur] + 1; 
                    next.push(s); 
                }
            }    
        }
        
        // return 
        if(dp.find(end) == dp.end()) return -1; 
        else return dp[end]; 
    }
};
