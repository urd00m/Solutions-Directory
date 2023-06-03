class Solution {
public:
    int recur(int cur, vector<vector<int>>& adjlist, vector<int>& informTime) {
        // leaf node
        if(adjlist[cur].size() == 0) {
            return 0; 
        }

        // need to inform people 
        int ret = 0; 
        for(int n : adjlist[cur]) {
            ret = max(ret, recur(n, adjlist, informTime));
        }
        ret += informTime[cur]; 
        return ret; 
    }

    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        // construct a graph 
        vector<vector<int>> adjlist = vector(n, vector(0, 0));
        for(int i = 0; i < n; i++) {
            if(i == headID) continue; 
            adjlist[manager[i]].push_back(i); 
        }
        return recur(headID, adjlist, informTime); 
    }
};
