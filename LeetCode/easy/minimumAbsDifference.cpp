class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        //sort 
        sort(arr.begin(), arr.end()); 
        
        vector<vector<int>> ret; 
        int min = INT32_MAX;
        for(long i = 0; i < arr.size()-1; i++) {
            vector<int> temp = {arr[i], arr[i+1]}; 
            int dif = abs(arr[i]-arr[i+1]); 
            if(dif < min) {
                min = dif;
                ret.clear();
                ret.push_back(temp);
            }
            else if(dif == min) {
                ret.push_back(temp); 
            }
        }
        
        return ret; 
    }
};

//2 minutes 
