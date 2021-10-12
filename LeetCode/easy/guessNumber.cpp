/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        long l = 1; 
        long r = n; 
        long mid = (l+r)/2; 
        int res = guess((int)mid); 
        while(res != 0) {
            if(res > 0) { //higher than guess 
                l = mid+1; 
            }
            else { //res < 0 == -1 lower than guess
                r = mid-1; 
            }
            mid = (l+r)/2;
            res = guess((int)mid); 
        }
        return mid; 
    }
};
