class Solution {
public:
    int dest; 
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        // check for endWord 
        bool exist = false; 
        Solution::dest = -1; 
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList[i] == endWord) {
                exist = true; 
                Solution::dest = i+1; // one index wordList
                break;
            } 
        }
        if(!exist) return {}; 
        
        // construct graph O(n^2) 
        vector<vector<int>> graph; // one index wordList

        // for begin word         
        vector<int> beginAdjList; 
        for(long i = 0; i < wordList.size(); i++) { 
            int mismatch = 0; 
            for(long j = 0; j < beginWord.size(); j++) 
                if(beginWord[j] != wordList[i][j]) mismatch++; 
            if(mismatch == 1)  // we can travel here 
                beginAdjList.push_back(i+1); 
        }
        graph.push_back(beginAdjList);
        
        // for word list 
        for(long i = 0; i < wordList.size(); i++) {
            vector<int> adjList; 
            for(long j = 0; j < wordList.size(); j++) { // for begin word 
                if(i == j) continue; 
                int mismatch = 0; 
                for(long k = 0; k < beginWord.size(); k++) 
                    if(wordList[i][k] != wordList[j][k]) mismatch++; 
                if(mismatch == 1)  // we can travel here 
                    adjList.push_back(j+1); 
            }
            graph.push_back(adjList); 
        }
        
        // bfs (graph min distance + storing path)
        int min = INT32_MAX;
        vector<vector<string>> ret; 
        vector<bool> visited = vector(wordList.size()+1, false); 
        vector<string> path; 
        path.push_back(beginWord);
        visited[0] = true; 
        
        // call bfs to find min 
        queue<vector<int>> next; // store cur and length 
        next.push({0, 1}); 
        while(next.empty() == false) {
            vector<int> cur = next.front(); next.pop(); 
            visited[cur[0]] = true; 
            
            if(cur[0] == Solution::dest) 
                if(cur[1] < min) {
                    min = cur[1]; 
                    continue; 
                }
            
            for(int n : graph[cur[0]]) 
                if(!visited[n]) next.push({n, cur[1]+1}); 
        }
        
        // call dfs to assemble ret 
        visited = vector(wordList.size()+1, false); 
        visited[0] = true; 
        dfs(visited, graph, ret, min, path, wordList, 0);
        
        return ret; 
    }
    
    // dfs function to assemble ret 
    void dfs(vector<bool>& visited, vector<vector<int>>& graph, vector<vector<string>>& ret, int& min, vector<string>& path, vector<string>& wordList, int cur) {
        // delete
        //for(string s : path) cout << s << " ";
        //cout << endl; 

        //visited[cur] = true; 
        if(cur == Solution::dest) {
            if(path.size() == min) {
                vector<string> temp = path; // deep copy 
                ret.push_back(temp); 
            }
            return;
        }
        if(path.size() >= min) return;
        
        // go to others 
        for(int next : graph[cur]) {
            path.push_back(wordList[next-1]); 
            if(!visited[next]) {
                visited[next] = true; 
                dfs(visited, graph, ret, min, path, wordList, next); 
                visited[next] = false; 
            }
            path.pop_back(); 
        }
    }
};

// this solution doesn't work mainly due to the dfs being inefficient, if the bfs stores parent information it would be able to greatly speed up the dfs (dfs just assembles results). 
