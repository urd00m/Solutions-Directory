class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        // count the chunks
        // sum time and remove the maximum balloon
        int ret = 0; long n = neededTime.size(); 
        char cur = '\0'; int sum = 0; int max_balloon = 0; 
        for(int i = 0; i < n; i++) {
            if(colors[i] != cur) {
                cur = colors[i]; 
                ret += sum - max_balloon; 
                max_balloon = 0; 
                sum = 0; 
            }
            sum += neededTime[i]; 
            max_balloon = max(max_balloon, neededTime[i]); 
        }
        // repeat for last baloon 
        ret += sum - max_balloon; 
        return ret; 
    }
};
