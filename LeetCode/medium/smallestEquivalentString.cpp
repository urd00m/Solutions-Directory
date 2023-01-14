class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        // greedy + floyd warshall there can only be 26 character nodes 
        // create adj matrix
        vector<vector<int>> adjmat = vector(26, vector(26, 0)); 
        for(int i = 0; i < s1.size(); i++) {
            adjmat[s1[i] - 'a'][s2[i] - 'a'] = 1; 
            adjmat[s2[i] - 'a'][s1[i] - 'a'] = 1; 
        }
        for(int i = 0; i < 26; i++) adjmat[i][i] = 1; // reflexive 

        // floyd warshall 
        for(int k = 0; k < 26; k++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    if(adjmat[i][k] && adjmat[k][j])
                        adjmat[i][j] = 1; 
                }
            }
        }

        // just choose minimum greedy 
        string ret = ""; 
        for(int i = 0; i < baseStr.size(); i++) {
            
            // find min char 
            int min; 
            for(int j = 0; j < 26; j++)
                if(adjmat[baseStr[i] - 'a'][j]) {
                    min = j; 
                    break; 
                }

            ret += string(1, 'a' + min); 
        }  
        return ret; 
    }
};
