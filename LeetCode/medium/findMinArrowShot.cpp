class Solution {
public:
    // static bool compare(vector<int>& a, vector<int>& b) {
    //     if(a[0] == b[0]) return a[1] > b[1];  // want the biggest span 
    //     else return a[0] < b[0];  // want the earliest start 
    // }

    // int findMinArrowShots(vector<vector<int>>& points) {
    //     // sort by start and end 
    //     // greedy subtract as much as possible 
    //     sort(points.begin(), points.end(), compare); 

    //     // iterate and find 
    //     int ret = 1; 
    //     int end = points[0][1]; 
    //     for(int i = 0; i < points.size(); i++) {
    //         if(points[i][0] > end) {
    //             ret++; 
    //             end = points[i][1]; 
    //         }
    //         else end = min(end, points[i][1]); 
    //     }
    //     return ret; 
    // }

    // optimized approach 
    int findMinArrowShots(vector<vector<int>>& points) {
        vector<pair<int, int>> p;
        for(vector<int>& ary : points) p.push_back({ary[0], ary[1]}); 

        // sort by start and end 
        // greedy subtract as much as possible 
        sort(p.begin(), p.end()); 

        // iterate and find 
        int ret = 1; 
        int end = p[0].second; 
        for(int i = 1; i < p.size(); i++) {
            cout << p[i].first << " " << p[i].second << endl; 
            if(p[i].first > end) {
                ret++; 
                end = p[i].second; 
            }
            else end = min(end, p[i].second);
        }
        return ret; 
    }
};
