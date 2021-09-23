class Solution {
public:
    string breakPalindrome(string palindrome) {        
        //base case 
        if(palindrome.length() <= 1) return "";
        
        //go left to right and find the first letter that isn't a and the middle 
        int mid = palindrome.length()/2;
        string ret = ""; 
        for(long i = 0; i < palindrome.length(); i++) {
            if(palindrome[i] == 'a' || (palindrome.length()%2==1 && i == mid)) {
                ret = ret + palindrome.substr(i, 1); 
                continue; 
            }
            ret = ret + "a" + palindrome.substr(i+1, palindrome.length()-i-1); 
            break;
        }
        if(ret == palindrome) { //if they are all a's then change the last char to 'b'
            ret[ret.length()-1] = 'b'; 
        }
        
        return ret; 
    }
};
