class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        // two bfs 
        // then scan and find minimum by lowest index 
        int n = edges.size(); 
        vector<int> dist1 = vector<int>(n, -1), dist2 = vector<int>(n, -1); 

        vector<int> v = vector<int>(n, 0); 
        int next = node1; int d = 0; 
        while(next != -1 && v[next] == 0) {
            dist1[next] = d++; 
            v[next] = 1; 
            next = edges[next]; 
        }
        v = vector<int>(n, 0); 
        next = node2; d = 0; 
        while(next != -1 && v[next] == 0) {
            dist2[next] = d++; 
            v[next] = 1; 
            next = edges[next]; 
        }

        // scan and find min 
        int min = INT32_MAX;
        int min_idx = -1; 
        for(int i = 0; i < n; i++) {
            if(dist1[i] == -1 || dist2[i] == -1) continue; 
            int m = max(dist1[i], dist2[i]); 
            if(m < min) {
                min = m;
                min_idx = i; 
            }
        }

        return min_idx; 
    }
};
