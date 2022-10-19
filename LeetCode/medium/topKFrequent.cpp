class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string, int> freq; 
        for(string s : words) {
            if(freq.find(s) == freq.end()) freq[s] = 0; 
            freq[s]++; 
        }
        
        // add to vector
        vector<pair<int, string>> ans; 
        for(auto& [s, f] : freq) 
            ans.push_back(make_pair(-f, s)); 
        
        // sort
        sort(ans.begin(), ans.end()); 
        
        // return solution
        vector<string> ret; 
        for(int i = 0; i < k; i++) 
            ret.push_back(ans[i].second); 
        
        return ret; 
        
    }
};
