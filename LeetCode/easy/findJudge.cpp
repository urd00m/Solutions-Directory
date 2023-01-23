class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        // create adj list 
        vector<vector<int>> adjlist = vector(n+1, vector(0, 0));    
        for(vector<int>& e : trust) adjlist[e[0]].push_back(e[1]); 

        // find judge 
        int judge = -1; 
        for(int i = 1; i <= n; i++) {
            if(judge == -1 && adjlist[i].size() == 0) judge = i; 
            else if(adjlist[i].size() == 0) return -1; // two judges? 
        }

        // verify town
        for(int i = 1; i <= n; i++) {
            if(i == judge) continue; 
            bool found = false;
            for(int item : adjlist[i])
                if(item == judge) {
                    found = true;
                    break; 
                }
            if(!found) return -1; 
        }
        return judge; 
    }
};
