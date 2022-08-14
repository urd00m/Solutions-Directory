class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> ans;
        int n = size(wordList), src = -1, dst = -1;
        for (int i = 0; i < n; i++) {
            if (wordList[i] == beginWord) src = i;
            else if (wordList[i] == endWord) dst = i;
        }
        if (dst == -1) return ans;
        if (src == -1) {
            wordList.push_back(beginWord);
            src = n++;
        }
        vector<int> adj[505], parent[505], path = {dst};
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isAdj(wordList[i], wordList[j])) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        bfs(adj, parent, src);
        dfs(wordList, ans, parent, path, dst);
        return ans;
    }
private:
    bool isAdj(string& s1, string& s2) {
        int dif = 0;
        for (int i = 0; i < size(s1); i++)
            dif += s1[i] != s2[i];
        return dif == 1;
    }
    
    void bfs(vector<int> adj[], vector<int> parent[], int& src) {
        int dist[505] = {};
        fill(begin(dist), end(dist), 505);
        dist[src] = 0;
        queue<int> q;
        q.push(src);
        parent[src] = {-1};
        while (!q.empty()) {
            int v = q.front();
            q.pop();
            for (int u: adj[v]) {
                if (dist[u] > dist[v] + 1) {
                    dist[u] = dist[v] + 1;
                    q.push(u);
                    parent[u] = {v};
                } else if (dist[u] == dist[v] + 1)
                    parent[u].push_back(v);
            }
        }
    }
    
    void dfs(vector<string>& wordList, vector<vector<string>>& ans, vector<int> parent[], vector<int>& path, int v) {
        if (v == -1) {
            vector<string> tmp(size(path)-1);
            transform(rbegin(path)+1, rend(path), begin(tmp), [&] (int& t) { return wordList[t]; });
            ans.push_back(move(tmp));
            return;
        }
        for (int u: parent[v]) {
            path.push_back(u);
            dfs(wordList, ans, parent, path, u);
            path.pop_back();
        }
    }
};

// this solution is similar to mine except it stores parent information, this allows it to be more efficient then my original solution
