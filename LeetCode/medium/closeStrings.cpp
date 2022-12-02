class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size()) return false; 

        // if letters are the same (must be the same letters)
        // then must have the same occurences of the letters 
        map<char, int> occ1, occ2; 
        for(char c : word1) {
            if(occ1.find(c) == occ1.end()) occ1[c] = 0; 
            occ1[c]++; 
        }
        for(char c : word2) {
            if(occ2.find(c) == occ2.end()) occ2[c] = 0; 
            occ2[c]++; 
        }

        // assert the same characters 
        for(const auto& [c, occ] : occ1) 
            if(occ2.find(c) == occ2.end()) return false; 
        for(const auto& [c, occ] : occ2) 
            if(occ1.find(c) == occ1.end()) return false;

        // occurence check 
        map<int, int> occ_visited; 
        int total = 0; 
        for(const auto& [c, occ] : occ1) {
            if(occ_visited.find(occ) == occ_visited.end())
                occ_visited[occ] = 0;
            occ_visited[occ]++;
            total++; 
        }
        for(const auto& [c, occ] : occ2) {
            if(occ_visited.find(occ) == occ_visited.end()) return false; 
            if(occ_visited[occ] == 0) return false; 
            occ_visited[occ]--;
            total--;
        }

        if(total != 0) return false;
        else return true; 
    }
};
