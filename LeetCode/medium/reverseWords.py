class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        l = s.split(" ") 
        l.reverse()
        ret = ""
        for w in l:
            if(len(w) == 0):
                continue
            ret += w.strip() + " "
        if(ret[-1] == " "): 
            ret = ret[:-1]
        return ret
