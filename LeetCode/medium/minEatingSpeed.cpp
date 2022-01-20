class Solution {
public:
    
    int minEatingSpeed(vector<int>& piles, int h) {
        // you know the maximum is the biggest pile 
        // absolute min is 0 
        // assuming you can always complete before the time is up 
        // binary search 
        
        int m = 0; 
        //find upper bound 
        for(int pile : piles) m = (pile > m ? pile : m);
        
        int l = 1; 
        int r = m;
        while(l < r) {
            int mid = (l+r)/2;
            if(canDo(mid, piles, h)) {
                r = mid; 
            }
            else {
                l = mid+1; 
            }
        }
        
        return l; 
    }
    
    bool canDo(int speed, vector<int>& piles, int h) {
        int hours = 0; 
        for(int pile : piles) {
            hours += pile/speed + (pile%speed != 0 ? 1 : 0); 
        }
        return hours <= h ? true : false; 
    }
};
