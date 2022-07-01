class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), compareBoxes); 
                
        int ret = 0; 
        int i = 0; 
        while(i < boxTypes.size() && truckSize > 0) {
            if(boxTypes[i][0] <= truckSize) {
                truckSize -= boxTypes[i][0];
                ret += boxTypes[i][1]*boxTypes[i][0]; 
            }
            else {
                ret += boxTypes[i][1]*truckSize; 
                truckSize -= truckSize;
            }
            i++; 
        }
        return ret; 
    }
    
    // sort boxes by units 
    static bool compareBoxes(vector<int>& a, vector<int>& b) {
        return a[1] > b[1]; 
    }
};
