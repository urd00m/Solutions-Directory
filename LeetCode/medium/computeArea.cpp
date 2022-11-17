class Solution {
public:
    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // get areas 
        int a_area = abs(ax2-ax1)*abs(ay2-ay1); 
        int b_area = abs(bx2-bx1)*abs(by2-by1); 

        // overlap x and y to find intersection
        int x_over = max(min(ax2, bx2) - max(bx1, ax1), 0); 
        int y_over = max(min(ay2, by2) - max(by1, ay1), 0); 

        return a_area + b_area - (x_over * y_over);  // two areas minus overlap 
    }
};
