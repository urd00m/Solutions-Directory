class Solution {
public:
    bool detectCapitalUse(string word) {
        if(word.size() == 1) return true; 

        // capital detection 
        bool first = isupper(word[0]); 
        bool second = isupper(word[1]); 
        
        if(first == false && second == true ) return false; 
        
        // scan 
        for(int i = 2; i < word.size(); i++) {
            if(isupper(word[i]) && second == false) return false; 
            if(!isupper(word[i]) && second == true) return false; 
        }
        return true; 
    }
};
