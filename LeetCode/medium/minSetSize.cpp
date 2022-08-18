class Solution {
public:
    
    static bool comp(vector<int>& a, vector<int>& b){
        return a[0] > b[0]; 
    }
    
    int minSetSize(vector<int>& arr) {
        // count occurences 
        vector<vector<int>> occ = vector(0, vector(2, 0));  
        vector<int> count = vector(100001, 0); 
        for(int item : arr) count[item]++; 
        for(int i = 0; i < 100001; i++) {
            if(count[i] != 0) occ.push_back({count[i], i}); 
        }
        
        // sort in descending order by first element 
        sort(occ.begin(), occ.end(), comp); 
        
        // delete till we get to the bottom 
        int ret = 0; 
        int total = arr.size(); 
        for(long i = 0; i < occ.size(); i++) {
            if(total <= arr.size()/2) break; 
            
            ret++; 
            total -= occ[i][0]; 
        }
        
        return ret;
    }
};
