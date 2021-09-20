class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int count[200] = {0}; //To fit ascii table, 0 is set to ' '
        unsigned long l = 0; unsigned long r = 0; 
        int max = 0;
        while(r < s.length()) {
            count[s[r]-' ']++; 
            //cout << "loop " << r << " " << s[r] << " " << count[s[r]-' '] << endl; 
            if(count[s[r]-' '] >= 2) {
                //calculate substring length 
                //cout << "hit" << endl; 
                max = max > r-l ? max : r-l; 
                
                //increment the last one until the situation is fixed 
                while(l < s.length()) {
                    count[s[l] - ' ']--;
                    if(s[l] == s[r]) break; 
                    l++; 
                    //cout << l << " " << r << " " << max << endl; 
                }
                l++; 
            }
            r++; 
        }
        //recout at the end 
        max = max > r-l ? max : r-l; 
        return max; 
    }
};
