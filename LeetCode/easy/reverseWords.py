class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = s.split(" ")
        
        # base check 
        if(len(s) == 0):
            return "" 
        
        # reverse each word 
        ret = ""
        ret += s[0][::-1] 
        for i in range(1, len(s)):
            ret += " " + s[i][::-1]
            
        return ret 
        
