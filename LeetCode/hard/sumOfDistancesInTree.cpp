class Solution {
public:
    void dfs1(vector<vector<int>>& adjlist, int cur, int par, vector<int>& children, vector<int>& dist) {
        // tree as long as we don't recur to parent we are fine 
        // calculate children values 
        for(int next : adjlist[cur]) {
            if(next == par) continue; 
            dfs1(adjlist, next, cur, children, dist); 
        }

        // calculate own value 
        for(int next : adjlist[cur]) {
            if(next == par) continue; 
            children[cur] += children[next]; 
            dist[cur] += dist[next]; 
        }
        dist[cur] += children[cur]; 
        children[cur]++;
    }

    void dfs2(vector<vector<int>>& adjlist, int cur, int par, vector<int>& children, vector<int>& dist) {
        // update current dist 
        if(par != -1) {
            dist[cur] = (children[par] - children[cur]) + dist[cur] + (dist[par] - dist[cur] - children[cur]); 
            children[cur] = children[par]; 
        }
        
        // visit all children
        for(int next : adjlist[cur]) {
            if(next == par) continue; 
            dfs2(adjlist, next, cur, children, dist); 
        }
    } 

    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        // 2 DFS plus dp
        // create adjlist 
        vector<vector<int>> adjlist = vector(n, vector<int>(0, 0)); 
        for(vector<int>& edge : edges) {
            adjlist[edge[0]].push_back(edge[1]);
            adjlist[edge[1]].push_back(edge[0]);
        }

        // initial dfs 
        vector<int> children = vector(n, 0); 
        vector<int> dist = vector(n, 0); 
        dfs1(adjlist, 0, -1, children, dist); 

        // calculation dfs 
        dfs2(adjlist, 0, -1, children, dist); 
        return dist; 
    }

    // floyd warshall O(n^3) too slow 
    // dijistrikas modified O(n^2 * log n) also too slow 
    // it is a tree, your root node contains a lot paths. APSP problem 
    // but not really, we just need the sum!!!! 
    // two dfs passes? 
    // each node stores num children (including itself) and total dist? 
    // one pass to determine num children and total dist relative to children 
    // cur->children = sum of children for children + 1 
    // cur->dist = sum of children for children + sum of children dist 
    // then dfs pass to calculate path dist for each node
    // calculated as follows, subtree_path (par->dist - cur->dist - cur->children) + (par->children - cur->children) + cur->dist
    // as we go down we also need to recenter the root 
    // new_value 
    // cur->children = par->children 
    // cur->dist = subtree_path
};
