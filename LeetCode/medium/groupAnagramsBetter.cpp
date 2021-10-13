class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map; 
        //vector<string> key_idx; 
        vector<vector<string>> ret; 
        
        for(string item : strs) {
            string key = item; 
            sort(key.begin(), key.end());
            //count items
            /*
            vector<int> letter(26, 0); 
            for(size_t i = 0; i < item.length(); i++) {
                letter[item[i]-'a']++; 
            }
            
            //convert to string
            string key = "";
            for(long i = 0; i < 26; i++) {
                key += (to_string(letter[i]) + " ");
            }
*/
            map[key].push_back(item);
        }
        
        // create ret 
        for(auto& item : map) {
            ret.push_back(item.second);
        }
        
        return ret; 
    }
};
