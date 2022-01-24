class Solution {
public:
    bool detectCapitalUse(string word) {
        //check all capital 
        bool allCap = true; 
        for(char c : word) {
            if(islower(c)) allCap = false; 
        }
        
        //check all lower
        bool allLow = true; 
        for(char c : word) {
            if(isupper(c)) allLow = false; 
        }
    
        // check if first letter is true 
        bool firstLetter = true; 
        if(islower(word[0])) firstLetter = false; 
        for(size_t i = 1; i < word.length(); i++) {
            if(isupper(word[i])) firstLetter = false; 
        }
        
        return allCap || allLow || firstLetter; 
    
    }
};
