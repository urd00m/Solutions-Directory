class Solution {
public:
    int mirrorReflection(int p, int q) {
        // mod 
        int side = 0; 
        int height = 0; 
        int up = 1; 
        while( (height != 0 || side == 0) && height != p) {
            if(up) {
                height += q; 
                if(height > p) { 
                    up = 0; 
                    height = p - (height - p); 
                }
            }
            else {
                height -= q; 
                if(height < 0) {
                    up = 1;
                    height = (-1*height);
                }
            }            
            side = (side+1)%2; 
            //cout << height << " " << side << endl; 
        }
        
        // ret
        if(height == 0) return 0;
        else if(side == 0) return 2; 
        else return 1; 
    }
};
