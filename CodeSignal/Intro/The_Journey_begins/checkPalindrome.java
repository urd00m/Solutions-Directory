boolean checkPalindrome(String inputString) {
    int r = inputString.length()-1; 
    for(int l = 0; l <= r; ) {
        if(inputString.charAt(l) != inputString.charAt(r)) {
            return false; 
        }
        l++; r--;
    }
    return true; 
}

