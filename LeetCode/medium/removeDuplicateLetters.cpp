class Solution {
public:
    string removeDuplicateLetters(string str) {
        // count 
        vector<int> cnt = vector(26, 0); 
        for(char c : str) 
            cnt[c - 'a']++;

        // greedy
        vector<int> v = vector(26, 0); 
        stack<int> s; 
        for(char c : str) {
            if(v[c - 'a']) {
                cnt[c - 'a']--; 
                continue; 
            }
            while(!s.empty() && s.top() >= (c - 'a')) {
                if(cnt[s.top()] - 1) {
                    cnt[s.top()]--; 
                    v[s.top()] = 0; 
                    s.pop(); 
                }
                else break; 
            }
            s.push(c -'a'); 
            v[c - 'a'] = 1; 
        }
        string ret = ""; 
        while(!s.empty()) {
            ret += string(1, s.top() + 'a'); 
            s.pop(); 
        }
        reverse(ret.begin(), ret.end());
        return ret; 
    }
};
