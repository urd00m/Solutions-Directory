class Solution {
public:
    vector<bool> visited;
    string ret;
    vector<vector<int>> adjList; 
    vector<int> idx; 
    vector<char> items; 
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        Solution::adjList = vector(s.size(), vector<int>(0)); //adjlist 
        Solution::visited = vector(s.size(), false);
        Solution::ret = s;  
        
        // Add to list 
        for(vector<int> pair : pairs) {
            adjList[pair[0]].push_back(pair[1]);
            adjList[pair[1]].push_back(pair[0]);
        }
        
        //dfs an
        for(int i = 0; i < s.size(); i++) {
            Solution::idx = vector(0, 0);
            Solution::items = vector(0, 'a'); 
            if(visited[i] == false) 
                dfs(i); 
            
            // Sort the idx and edit ret then continue (There shouldn't be any overlap between visists)
            sort(Solution::items.begin(), Solution::items.end()); 
            sort(Solution::idx.begin(), Solution::idx.end()); 
            
            for(long i = 0; i < idx.size(); i++) {
                Solution::ret[Solution::idx[i]] = Solution::items[i]; 
            }
        }
        
        return Solution::ret; 
    }
    
    void dfs(int cur) {
        if(Solution::visited[cur] == false) {
            Solution::visited[cur] = true; 
            Solution::idx.push_back(cur);
            Solution::items.push_back(Solution::ret[cur]);
            for(int next : Solution::adjList[cur]) 
                dfs(next); 
        }
    }
};
