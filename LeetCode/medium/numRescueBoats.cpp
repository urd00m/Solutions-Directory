class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        //sort
        sort(people.begin(), people.end());
        int ret = 0; 
        long left = 0; 
        long right = people.size()-1; 
        
        //then two pointers 
        while(left <= right) {
            if(left == right) {
                ret++;
                break; 
            }
            if(people[right] + people[left] > limit) {
                ret++; 
                right--; 
            }
            else {
                ret++;
                left++;
                right--; 
            }
        }
        
        return ret; 
    }
};
