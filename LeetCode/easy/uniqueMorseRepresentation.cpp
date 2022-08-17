class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        unordered_set<string> exists; 
        vector<string> map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
        
        // convert to strings and add 
        int ret = 0; 
        for(string s : words) {
            string morse_encoded = convert(map, s); 
            if(exists.find(morse_encoded) == exists.end()) {
                ret++; 
                exists.insert(morse_encoded); 
            }
        }
        
        return ret; 
    }
    
    string convert(vector<string>& map, string word) {
        string ret = ""; 
        for(char c : word) {
            ret += map[c-'a'];
        }
        return ret; 
    }
};
