class Solution {
public:
    bool isRobotBounded(string instructions) {
        
        //simulate one iteration 
        int x = 0; int y = 0; 
        char facing = 'N'; 
        for(char inst : instructions) {
            if(inst == 'G') {
                if(facing == 'N') y++; 
                else if(facing == 'S') y--;
                else if(facing == 'E') x++; 
                else x--; 
            }
            else if(inst == 'L') {
                if(facing == 'N') facing = 'W'; 
                else if(facing == 'S') facing = 'E';
                else if(facing == 'E') facing = 'N';
                else facing = 'S';  
            }
            else if(inst == 'R') {
                if(facing == 'N') facing = 'E'; 
                else if(facing == 'S') facing = 'W';
                else if(facing == 'E') facing = 'S';
                else facing = 'N';  
            }
        }
        if(x == 0 && y == 0) return true; 
        
        //simulate next one 
        int counter = 0; 
        while(counter++ < 100) {
            for(char inst : instructions) {
                if(inst == 'G') {
                    if(facing == 'N') y++; 
                    else if(facing == 'S') y--;
                    else if(facing == 'E') x++; 
                    else x--; 
                }
                else if(inst == 'L') {
                    if(facing == 'N') facing = 'W'; 
                    else if(facing == 'S') facing = 'E';
                    else if(facing == 'E') facing = 'N';
                    else facing = 'S';  
                }
                else if(inst == 'R') {
                    if(facing == 'N') facing = 'E'; 
                    else if(facing == 'S') facing = 'W';
                    else if(facing == 'E') facing = 'S';
                    else facing = 'N';  
                }
            }
            if(x == 0 && y == 0) return true; //return to origin 
        }
        return false; 
        

    }
};
