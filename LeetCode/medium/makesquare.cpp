class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        // divisible by 4 check 
        long total_size = 0L; 
        for(int length : matchsticks)
            total_size += static_cast<long>(length);
        
        if(total_size%4 != 0) return false; // not possible 
        long sidelength = total_size/4L; 
        sort(matchsticks.rbegin(), matchsticks.rend()); 
        if(matchsticks[matchsticks.size()-1] > sidelength) return false; // not possible 

        // dfs 
        vector<long> save = vector(4, 0L); 
        return dfs(save, matchsticks, 0, sidelength);
    }
    
    bool dfs(vector<long>& save, vector<int>& matchsticks, int cur, long sidelength) {
        if(cur >= matchsticks.size()) {
            if(save[0] == save[1] && save[1] == save[2] && save[2] == save[3]) return true;
            else return false; 
        }
        
        //assign to each side 
        for(int i = 0; i < 4; i++) {
            if(save[i] + matchsticks[cur] > sidelength) continue; 
            save[i] += matchsticks[cur]; 
            if(dfs(save, matchsticks, cur+1, sidelength)) return true; 
            save[i] -= matchsticks[cur]; 
        }
        
        return false; 
    }
    
    
};
