class Solution(object):
    
    def nextElement(self, s, cur):
        while(cur < len(s) and s[cur] == "_"):
            cur += 1 
        return cur
    
    def canChange(self, start, target):
        """
        :type start: str
        :type target: str
        :rtype: bool
        """
        startNew = start.replace("_", "")
        targetNew = target.replace("_", "")
        if(startNew != targetNew):
            return False

        # determine fitting 
        startIdx = -1
        targetIdx = -1
        for _ in range(len(startNew)): 
            startIdx = self.nextElement(start, startIdx+1)
            targetIdx = self.nextElement(target, targetIdx+1)
            
            if(startIdx < targetIdx and start[startIdx] != "R"):
                return False 
            if(startIdx > targetIdx and start[startIdx] != "L"):
                return False
            
        return True 
    
