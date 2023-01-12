class Solution {
public:

    // returns a 26 vector which contains the times we have came across label in the children 
    vector<int> dfs(int cur, int par, vector<vector<int>>& adjlist, string& labels, vector<int>& ret) {
        // store 
        vector<int> count = vector<int>(26, 0); 
        count[labels[cur] - 'a']++; 

        // check children 
        for(int next : adjlist[cur]) {
            if(next != par) {
                vector<int> temp = dfs(next, cur, adjlist, labels, ret); 
                for(int i = 0; i < 26; i++) count[i] += temp[i]; 
            }
        }

        // add 
        ret[cur] = count[labels[cur] - 'a']; 
        return count; 
    }

    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string& labels) {
        // construct adjlist 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(vector<int>& edge : edges) {
            adjlist[edge[0]].push_back(edge[1]);
            adjlist[edge[1]].push_back(edge[0]);
        }

        // dfs 
        vector<int> ret = vector(n, 0); 
        dfs(0, -1, adjlist, labels, ret); 
        return ret; 
    }
};
