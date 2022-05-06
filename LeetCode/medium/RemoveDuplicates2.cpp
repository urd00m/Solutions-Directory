class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char, int>> sck;
        
        for(long i = 0 ; i < s.size(); i++) {
            char cur = s[i];
            
            if(sck.empty() == false && sck.top().first == cur) {
                if(sck.top().second < k-1) sck.top().second++; 
                else if(sck.top().second == k-1) sck.pop(); 
            }
            else {
                pair<char, int> temp(cur, 1); 
                sck.push(temp); 
            }
        }
        
        // create string 
        string ret = "";
        while(sck.empty() == false) {
            pair<char, int> cur = sck.top(); sck.pop(); 
            for(int i = 0; i < cur.second; i++)
                ret += cur.first; 
        }
        reverse(ret.begin(), ret.end()); 
        return ret; 
    }
};
