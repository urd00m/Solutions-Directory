class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        // bitmask skills! 
        // create map 
        size_t n = req_skills.size(); 
        unordered_map<string, int> m; 
        for(int i = 0; i < n; i++) m[req_skills[i]] = i; 

        // create masks for each person 
        vector<int> mask = vector(people.size(), 0); 
        for(int i = 0; i < people.size(); i++)
            for(string& s : people[i]) mask[i] += (1<<m[s]); 

        // begin dp  -> can iterate through the bitmask because each time we add a person the bitmask can only increase
        vector<vector<int>> dp = vector(1<<n, vector(0, 0)); 
        for(int i = 0; i < (1<<n); i++) {
            if(i != 0 && dp[i].size() == 0) continue; 
            for(int j = 0; j < people.size(); j++) {
                if(people[j].size() == 0) continue; 
                if(dp[i | mask[j]].size() == 0 || dp[i | mask[j]].size() > dp[i].size() + 1) {
                    vector<int> temp = dp[i]; 
                    temp.push_back(j); 
                    dp[i | mask[j]] = temp; 
                }
            }
        }
        return dp[(1<<n)-1]; 
    }
};
