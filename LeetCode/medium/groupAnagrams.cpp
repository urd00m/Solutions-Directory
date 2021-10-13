class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map; 
        vector<string> key_idx; 
        vector<vector<string>> ret; 
        
        for(string item : strs) {
            //count items
            vector<int> letter(26, 0); 
            for(size_t i = 0; i < item.length(); i++) {
                letter[item[i]-'a']++; 
            }
            
            //convert to string
            string key = "";
            for(long i = 0; i < 26; i++) {
                key += (to_string(letter[i]) + " ");
            }
            
            //check if it exists
            if(map.find(key) == map.end()) { //does not exist
                map[key] = vector<string>(1, item); 
                key_idx.push_back(key);
            } 
            else {
                map[key].push_back(item);
            }
        }
        
        // create ret 
        for(string item : key_idx) {
            ret.push_back(map[item]);
        }
        
        return ret; 
    }
};
