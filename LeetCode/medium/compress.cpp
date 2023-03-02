class Solution {
public:
    int compress(vector<char>& chars) {
        int count = 1; 
        for(int i = 1; i < chars.size()+1; i++) {
            if(i == chars.size() || chars[i] != chars[i-1]) {
                if(count == 1) continue; 
                else {
                    //remove count -1 times 
                    chars.erase(chars.begin()+i-count+1, chars.begin()+i);
                    i -= count-1; 
                    string c = to_string(count);
                    for(int j = 0; j < c.size(); j++) {
                        chars.insert(chars.begin()+i, c[j]);  
                        i++;
                    }
                    count = 1;
                }
            }
            else count++; 
        }

        return chars.size(); 
    }
};
