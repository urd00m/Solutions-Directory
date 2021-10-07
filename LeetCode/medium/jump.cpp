class Solution {
public:
    int jump(vector<int>& nums) {
        vector<vector<pair<int, int>>> graph(nums.size(), vector<pair<int,int>>(0)); 
        //dijistrika's algorithm
        //assemble graph 
        for(long i = 0; i < nums.size(); i++) {
            for(long j = i+1; j <= (nums[i] + i < nums.size()-1 ? nums[i]+i : nums.size()-1); j++) {
                graph[i].push_back(make_pair(static_cast<int>(j),1));
            }
        }
        return dpq(graph, nums.size());    
    }
    
    int dpq(vector<vector<pair<int,int>>>& graph, int n) {
        //vector<bool> visited(n, false);
        vector<int> dist(n, 1000000000); 
        priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>> > pq;
        pq.push(make_pair(0, 0)); 
        dist[0] = 0; 
        while(pq.empty() == false) {
            pair cur = pq.top(); pq.pop(); 
            //visited[cur.second] == true; 
            int d = cur.first, u = cur.second; 
            if(d > dist[u]) continue; 
            for(int j = 0; j < (int)graph[u].size(); j++) {
                pair v = graph[u][j]; 
                //if(visited[v.first] == true) continue; 
                if(dist[u] + v.second < dist[v.first]) {
                    dist[v.first] = dist[u] + v.second; 
                    pq.push(make_pair(dist[v.first], v.first)); 
                }
            }
        }
        return dist[n-1];
    }
};
