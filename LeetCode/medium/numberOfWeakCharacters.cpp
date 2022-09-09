class Solution {
public:
    
    static bool compare(vector<int>& a, vector<int>& b) {
        if(a[0] != b[0]) return a[0] > b[0]; 
        else return a[1] < b[1]; 
    }
    
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        // sort by attack 
        sort(properties.begin(), properties.end(), compare); 
        
        int ret = 0; 
        int maxDefense = INT32_MIN;
        
        for(vector<int>& a : properties) {
            if(a[1] < maxDefense) ret++; 
            else
                maxDefense = a[1];
        }
        
        return ret; 
    }
};
