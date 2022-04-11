import numpy as np 
class Solution(object):
    def shiftGrid(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        grid = np.array(grid)
        flat = grid.flatten()
        k = k % len(flat)
        
        # shift by k 
        ret = np.append(flat[-k:], flat[:-k])
        ret = ret.reshape(grid.shape)
        return ret 
        
