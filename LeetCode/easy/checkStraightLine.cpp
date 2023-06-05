class Solution {
public:

    static bool compare(vector<int>& a, vector<int>& b) {
        if(a[0] == b[0]) return a[1] < b[1];
        else return a[0] < b[0]; 
    }

    bool checkStraightLine(vector<vector<int>>& coordinates) {
        // need to make sure order is correct
        sort(coordinates.begin(), coordinates.end(), compare); 

        // slope must be constant 
        double slope = ((double)coordinates[1][1]-coordinates[0][1])/((double)coordinates[1][0] - coordinates[0][0]); 

        // make sure slope matches
        for(int i = 1; i < coordinates.size(); i++) {
            double s = ((double)coordinates[i][1]-coordinates[i-1][1])/((double)coordinates[i][0] - coordinates[i-1][0]); 
    
            if(slope != s) return false;
        }
        return true;
    }
};
