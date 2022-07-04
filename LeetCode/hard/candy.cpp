class Solution {
public:
    
    static bool compare(vector<int>& a, vector<int>& b) {
        return a[0] < b[0]; 
    }
    
    int candy(vector<int>& ratings) {
        //sort then assign by greedy 
        vector<vector<int>> new_ratings = vector(ratings.size(), vector(2, -1)); 
        for(long i = 0; i < ratings.size(); i++) {
            new_ratings[i][0] = ratings[i];
            new_ratings[i][1] = i; 
        }
        
        sort(new_ratings.begin(), new_ratings.end(), compare); 
        
        //assign and check index 
        vector<int> idx_rating = vector(ratings.size(), 0); 
        int ret = 0; 
        for(long i = 0; i < new_ratings.size(); i++) {
            int cur_num = new_ratings[i][0]; 
            int cur_idx = new_ratings[i][1]; 
            
            int min_rating = 0; 
            if(cur_idx-1 >= 0 && idx_rating[cur_idx-1] != 0 && ratings[cur_idx-1] != ratings[cur_idx]) // must be at least one 
                min_rating = max(min_rating, idx_rating[cur_idx-1]); 
            if(cur_idx+1 < ratings.size() && idx_rating[cur_idx+1] != 0 && ratings[cur_idx+1] != ratings[cur_idx]) // must be at least one 
                min_rating = max(min_rating, idx_rating[cur_idx+1]); 
            min_rating++; 
            
            ret += min_rating; 
            idx_rating[cur_idx] = min_rating;  
        }
        
        
        return ret; 
    }
};

// slower than most other algorithms submitted (5%) but runtime is only 131 ms. 
