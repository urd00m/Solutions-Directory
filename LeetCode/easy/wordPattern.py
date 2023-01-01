class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        n = len(pattern) 
        spl = s.split()
        if(len(spl) != n):
            return False 

        dict = {} 
        visited = set([])
        for i in range(0, n):
            if(pattern[i] in dict and not spl[i] == dict[pattern[i]]):
                return False
            elif(pattern[i] not in dict):
                if(spl[i] in visited):
                    return False
                dict[pattern[i]] = spl[i]
                visited.add(spl[i])

        return True
