class Solution {
public:
    static bool compare(pair<char, int>& p1, pair<char, int>& p2) {
        return p1.second > p2.second; 
    }

    string frequencySort(string s) {
        // reconstruct string 
        unordered_map<char, int> freq; 
        for(char c : s) {
            if(freq.find(c) == freq.end()) 
                freq[c] = 0;
            freq[c]++; 
        }

        // reconstruct and sort
        vector<pair<char,int>> freq_pair; 
        for(const auto& [c, f] : freq) 
            freq_pair.push_back({c, f}); 
        sort(freq_pair.begin(), freq_pair.end(), compare); 

        // reconstruct string
        string ret = ""; 
        for(pair<char, int>& p : freq_pair) 
            for(int i = 0; i < p.second; i++) 
                ret += string(1, p.first);

        return ret; 
    }
};
