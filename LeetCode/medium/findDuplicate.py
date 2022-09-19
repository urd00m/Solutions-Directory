class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        map = {} 
        for path in paths: 
            # get directory 
            path_split = path.split(" ")
            directory = path_split[0]
            
            # grab files 
            for i in range(1, len(path_split)): 
                filename = path_split[i] 
                    
                # grab contents 
                contents = path_split[i].split("(")[1].strip()[:-1] # ignore the last character

                # create path name 
                pathname = directory + "/" + filename.split("(")[0]
                
                # existence check
                if map.has_key(contents) == False:
                    map[contents] = []
                map[contents].append(pathname) 
                
        # assemble and return
        ret = []
        for key in map.keys():
            if(len(map[key]) == 1):
                continue
            ret.append(map[key]) 
        return ret
