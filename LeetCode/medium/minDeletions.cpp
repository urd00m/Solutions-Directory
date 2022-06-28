class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq = vector(26, 0); 
        for(char c : s) freq[c-'a']++;
        int ret = 0; vector<int> exists = vector(100001, 0); 
        for(int f : freq) {
            if(f == 0) continue; 
            if(exists[f]) {
                do 
                    ret++; 
                while(exists[--f]);
            }
            if(f != 0) exists[f] = 1; 
        }
        return ret; 
    }
};
