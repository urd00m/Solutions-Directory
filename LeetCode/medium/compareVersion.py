
import numpy as np
class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        a = np.array(version1.split("."), dtype="int")
        b =  np.array(version2.split("."), dtype="int")
        n = max(len(a), len(b))
        for i in range(n):
            c1 = -1
            c2 = -1 
            if(i >= len(a)):
                c1 = 0
            else: 
                c1 = a[i]
                
            if(i >= len(b)):
                c2 = 0
            else: 
                c2 = b[i]

            if(c1 > c2):
                return 1 
            elif(c2 > c1): 
                return -1
    
        return 0
        
