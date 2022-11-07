class Solution {
public:
    int maximum69Number (int num) {
        string s = to_string(num); 
        for(size_t i = 0; i < s.size(); i++) 
            if(s[i] == '6') {
                s[i] = '9';
                return stoi(s); 
            }
        return num;  
    }
};
