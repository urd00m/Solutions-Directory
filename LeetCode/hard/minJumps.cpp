class Solution {
public:
    int minJumps(vector<int>& arr) {
        // this is screaming dp 
        // a union set
        long n = arr.size(); 
        unordered_map<int, vector<int>> m; 

        // assemble 
        for(int i = 0; i < n; i++) {
            if(m.find(arr[i]) != m.end())
                m[arr[i]].push_back(i);
            else
                m[arr[i]] = {i}; 
        }

        // run dijkstras 
        vector<int> d = vector(n, INT32_MAX); d[0] = 0; 
        vector<int> v = vector(n, 0); 
        priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> pq; pq.push({0, 0}); // mapping first is dist, second is index 
        while(!pq.empty()) {
            pair<int,int> c = pq.top(); pq.pop(); 
            int s = c.first; 
            int idx = c.second; 
            // cout << idx << " " << arr[idx] << " " << s << " " << d[idx] << endl; 

            // mark visited
            if(v[idx]) continue; 
            v[idx] = 1; 
            
            // visited all neighbors 
            // left and right neighbors 
            if(idx-1 >= 0 && !v[idx-1] && s < d[idx-1]) {
                d[idx-1] = s + 1;
                pq.push({d[idx-1], idx-1});
            }
            if(idx+1 < n && !v[idx+1] && s+1 < d[idx+1] ) {
                d[idx+1] = s + 1;
                pq.push({d[idx+1], idx+1});
            }

            // visit those in the same arr set 
            while(m[arr[idx]].size()) {
                int i = m[arr[idx]].size()-1; 
                int cs = m[arr[idx]][i]; 
                if(cs != idx) {
                    if(!v[cs] && s+1 < d[cs]) {
                        d[cs] = s+1; 
                        pq.push({d[cs], cs}); 
                    }
                }
                m[arr[idx]].pop_back(); 
            }
        }
        return d[n-1]; 
    }
};
