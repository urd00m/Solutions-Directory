class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // if it is a dag (i.e. no cycles) BFS 
        queue<int> n; 

        // find source nodes 
        vector<int> cnt = vector<int>(numCourses, 0); 
        vector<vector<int>> adjlist = vector(numCourses, vector(0, 0)); 
        for(vector<int>& p : prerequisites) {
            cnt[p[1]]++; 
            adjlist[p[0]].push_back(p[1]); 
        }
        for(int i = 0; i < numCourses; i++) if(!cnt[i]) n.push(i); 

        // kahn's algo 
        int nv = 0; 
        while(!n.empty()) { 
            int c = n.front(); n.pop();     
            nv++; 

            // subtract cnt
            for(int next : adjlist[c]) if(--cnt[next] == 0) n.push(next); 
        }
        return (nv == numCourses); 
    }
};
