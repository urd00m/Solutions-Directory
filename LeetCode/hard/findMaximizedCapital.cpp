class Compare {
    public:
    bool operator() (pair<int,int>& a, pair<int,int>& b) {
        return a.second < b.second; 
    }
};

class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        // assemble 
        vector<pair<int,int>> pc = vector<pair<int,int>>(0, pair<int,int>()); 
        for(int i = 0; i < profits.size(); i++) 
            pc.push_back({capital[i], profits[i]}); 
        
        // sort array 
        sort(pc.begin(), pc.end()); 

        // pq 
        priority_queue<pair<int, int>, vector<pair<int,int>>, Compare> pq; 
        
        // fill 
        int ptr = 0; 
        while(ptr < pc.size() && pc[ptr].first <= w) pq.push(pc[ptr++]); 

        // assemble
        int tc = w; 
        for(int i = 0; i < k; i++) {
            if(pq.empty()) return tc; 

            // get cur and add 
            pair<int,int> c = pq.top(); pq.pop(); 
            tc += c.second; 

            // find new ones 
            while(ptr < pc.size() && pc[ptr].first <= tc) pq.push(pc[ptr++]); 
        }

        return tc; 
    }
};
