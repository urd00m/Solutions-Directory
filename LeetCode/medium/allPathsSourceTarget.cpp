class Solution {
public:
    vector<vector<int>> solution; 
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        Solution::solution.clear(); 
        vector<int> path; 
        recur(0, graph, path); 
        return Solution::solution; 
    }
    
    void recur(int curNode, vector<vector<int>>& graph, vector<int>& path) {
        if(curNode == graph.size()-1) {
            path.push_back(curNode); 
            Solution::solution.push_back(path); 
            path.pop_back(); 
        }
        else {
            path.push_back(curNode);
            for(int item : graph[curNode]) {
                recur(item, graph, path); 
            }
            path.pop_back(); 
        }
    }
};
