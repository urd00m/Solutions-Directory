class Solution {
public:
    bool checkIfPangram(string sentence) {
        vector<int> visited = vector(26, 0); 
        for(char c : sentence) visited[c - 'a'] = 1; 
        for(int a : visited) if(a == 0) return false;
        return true; 
    }
};
