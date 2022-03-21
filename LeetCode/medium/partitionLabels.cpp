class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<long> mapToFar(26, -1); 
        
        
        //fill in map 
        for(long i = 0; i < s.length(); i++) {
            mapToFar[s[i] - 'a'] = i; 
        }
        
        // Fill in ret 
        long i = 0; 
        vector<int> ret; 
        while(i < s.length()) {
            long j = i;
            long far = mapToFar[s[i] - 'a']; 
            while(j < far) {
                far = mapToFar[s[j] - 'a'] > far ? mapToFar[s[j] - 'a'] : far; 
                j++; 
            }
            ret.push_back(j - i + 1); 
            i = far+1; 
        }
        
        return ret; 
    }
};
