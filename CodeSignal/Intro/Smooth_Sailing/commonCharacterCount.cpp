int commonCharacterCount(string s1, string s2) {
    int a[26] = {0}; int b[26] = {0}; 
    
    for(unsigned long i = 0; i < s1.length(); i++) {
        a[s1[i] - 'a']++; 
    }
    for(unsigned long i = 0; i < s2.length(); i++) {
        b[s2[i] - 'a']++; 
    }
    int count = 0; 
    for(unsigned long i = 0; i < 26; i++) {
        count += a[i] < b[i] ? a[i] : b[i]; 
    }
    return count; 
 }

