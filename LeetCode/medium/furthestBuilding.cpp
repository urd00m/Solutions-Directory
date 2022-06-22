class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int> pq;
        
        
        // priority queue
        // solution taken from discuss, but it was what I had in mind just more clever. Basically you can do a greedy approach use the ladders for the biggest run the idea from discuss that I'm going to use is to use a priority queue 
        if(heights.size() == 1) return 0; 
        
        // remove bricks till zero, once zero add back the number of bricks and use a ladder for the most expensive one and remove ladder, once you run out of ladders (== -1) you stop iteration 
        int cur = 1; 
        while(ladders != -1) {
            if(heights[cur] > heights[cur-1]) { // need to use bricks or ladder 
                int diff = heights[cur] - heights[cur-1];
                bricks -= diff; 
                pq.push(diff);
                
                if(bricks < 0) {
                    int back = pq.top(); pq.pop(); // used a ladder 
                    bricks += back; 
                    ladders--; 
                    if(ladders == -1) break; 
                }
            }
            cur++; 
            if(cur == heights.size()) break; //out of bounds 
        }
        return cur-1; // can't get further than the -1 
        
        
    }
};
