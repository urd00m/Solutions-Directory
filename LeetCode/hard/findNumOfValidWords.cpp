class Solution {
public:
    long wordToBitmask(string& word) {
        long letters[26]{0}; 
        for(char c : word) {
            letters[c - 'a'] = 1; 
        }
        long ret = 0; 
        for(long i = 0; i < 26; i++) {
            ret = ret | (letters[i])<<i;
        }
        //cout << ret <<  " " << word << endl; 

        return ret; 
    }
    
    //test function
    string bitmaskToLetters(long bitmask) {
        string ret = ""; 
        for(long i = 0; i < 26; i++) {
            if(bitmask&(1<<i)) ret += string(1, 'a'+i); 
        }
        return ret; 
    }
    
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        // Word bitmask 
        // calculate subsets for the puzzles and see if they exist in the word bitmask 
        
        //calculate bitmasks for the words 
        long n = words.size(); 
        long m = puzzles.size(); 
        unordered_map<long, long> mapToBitmask; //bitmask to count 
        for(long i = 0; i < n; i++) { 
            long bitmask = wordToBitmask(words[i]); 
            if(mapToBitmask.find(bitmask) == mapToBitmask.end()) mapToBitmask[bitmask] = 0; 
            mapToBitmask[bitmask]++; 
        }
        
        //Iterate through the subsets of puzzles to find a match 
        vector<int> ret; 
        for(long i = 0; i < m; i++) { //iterate through puzzles 
            long bitmask = wordToBitmask(puzzles[i]); //get its bitmask 
            int count = mapToBitmask[bitmask];
            long firstLetter = 1<<(puzzles[i][0]-'a'); 
            for(long subset = (bitmask-1)&bitmask; subset > 0; subset = (subset-1)&bitmask) {
                if((subset & firstLetter) == 0) {
                    //cout << "skipped " << bitmaskToLetters(subset) << endl; 
                    continue; 
                }
                count += mapToBitmask[subset]; 
                //cout << bitmask << " " << subset << " " << count << " " << bitmaskToLetters(subset) << " " << firstLetter << " " << (subset & firstLetter) << endl; 
            } //don't care about the empty subset 
            ret.push_back(count); 
        }
        
        return ret;
    }
};

//had a idea that it was probably bitmask 
//failed to notice that you can iterate through all the possible subsets of the puzzles and match them instantly 
//also failed to realize trick for subsets where you do (subset-1)&bitmask to iterate through the subsets
//took around 30 minutes 

