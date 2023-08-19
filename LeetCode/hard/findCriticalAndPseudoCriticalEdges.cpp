#define CRITICAL 0
#define PSUEDO 1 

#define TO 0
#define WEIGHT 1
#define IDX 2 

class Solution {
public:
    int calc_mst(vector<vector<vector<int>>>& adjlist, vector<vector<int>>& edges, int ignore, int must_use) {
        vector<int> v = vector(adjlist.size(), 0); 
        int tot_v = 0; 
        
        // use priority queue - prim's algorithm 
        // set up must use 
        int ret = 0;
        if(must_use != -1) ret += edges[must_use][2]; 

        // create MST 
        priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> pq; 
        if(must_use != -1) {
            pq.push({0, edges[must_use][0]});
            pq.push({0, edges[must_use][1]});
            // v[edges[must_use][0]] = 1; 
            // v[edges[must_use][1]] = 1; 
            // tot_v += 2; 
        } else {
            pq.push({0, 0}); 
            // v[0] = 1; 
            // tot_v++;
        }

        // begin algo 
        while(!pq.empty()) {
            pair<int, int> c = pq.top(); pq.pop(); 
            if(v[c.second]) continue; 
            v[c.second] = 1; 
            ret += c.first; 
            tot_v++; 

            // visit children 
            for(vector<int>& n : adjlist[c.second]) {
                if(n[IDX] == ignore || v[n[TO]]) continue; 

                // add to pq 
                pq.push({n[WEIGHT], n[TO]}); 
            }
        }
        
        // check if visited everything
        if(tot_v != adjlist.size()) return INT32_MAX;
        else return ret; 
    }

    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        vector<vector<int>> ret = vector(2, vector(0, 0)); 

        // iterate through all MST? 
        // calculate MST --> after removing an edge 
        // if increases we have critical edge
        // if stays the same then we have psuedo edge 
        // --> or useless edge (if we force it to use that edge and weight increases)
        // MST algo --> O(nlogn)
        // for each edge O(n^2) 
        // total time O(n^3 log n)

        // create adjlist 
        vector<vector<vector<int>>> adjlist(n, vector<vector<int>>(0)); 
        for(int i = 0; i < edges.size(); i++) {
            vector<int>& e = edges[i]; 
            adjlist[e[0]].push_back({e[1], e[2], i});
            adjlist[e[1]].push_back({e[0], e[2], i});
        }

        // calculate true MST 
        int true_mst_value = calc_mst(adjlist, edges, -1, -1); 
        cout << true_mst_value << endl; 

        // remove edges 
        for(int i = 0; i < edges.size(); i++) {
            int value_if_remove = calc_mst(adjlist, edges, i, -1); 
            if(value_if_remove > true_mst_value) ret[CRITICAL].push_back(i);
            else if(value_if_remove == true_mst_value) {
                int value_if_forced = calc_mst(adjlist, edges, -1, i);
                if(value_if_forced == true_mst_value) ret[PSUEDO].push_back(i);
            }
        }
        return ret; 
    }
};
