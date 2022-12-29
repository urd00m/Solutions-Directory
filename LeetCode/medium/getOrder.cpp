class Solution {
public:
    static bool compare_sort(vector<int>& a, vector<int>& b) {
        if(a[0] == b[0]) {
            if(a[1] == b[1]) return a[2] < b[2]; 
            else return a[1] < b[1];
        }
        else return a[0] < b[0]; 
    }

    static bool compare_pq(vector<int>& a, vector<int>& b) {
        if(a[1] == b[1]) return a[2] > b[2]; 
        else return a[1] > b[1]; 
    }

    vector<int> getOrder(vector<vector<int>>& tasks) {
        // need to add index to the tasks
        for(int i = 0; i < tasks.size(); i++) tasks[i].push_back(i); 

        // simulation
        // sort by enqueue time with (don't care about tie breaker right now)
        // then add all available to priority queue which sorts by processing time then by index 
        sort(tasks.begin(), tasks.end(), compare_sort); 
        priority_queue<vector<int>, vector<vector<int>>, decltype(&compare_pq)> pq(compare_pq); 

        // begin simul 
        vector<int> ret; 
        long time = tasks[0][0]; // starting point 
        int tasks_idx = 0; 
        int processed = 0; 
        while(processed != tasks.size()) {
            // add valid to pq 
            while(tasks_idx < tasks.size() && (long)tasks[tasks_idx][0] <= time) {
                pq.push(tasks[tasks_idx]); 
                tasks_idx++; 
            } 

            // pick cur to process 
            if(pq.empty()) { // if empty jump to the next idx 
                time = tasks[tasks_idx][0]; 
                pq.push(tasks[tasks_idx++]); 
            }
            vector<int> cur = pq.top(); pq.pop(); 
            ret.push_back(cur[2]); 
            time += (long)cur[1]; 
            processed++; 
        }

        return ret; 
    }
};
