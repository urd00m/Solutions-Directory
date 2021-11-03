vector<vector<int>> boxBlur(vector<vector<int>> image) {
    long n = image.size(); 
    long m = image[0].size(); 
    vector<vector<int>> ret(n-2, vector(m-2, -1));
    for(long i = 0;  i < n-2; i++) {
        for(long j = 0; j < m-2; j++) {
            
            int average = 0; 
            for(long row = 0; row < 3; row++) {
                for(long col = 0; col < 3; col++) {
                    average += image[i+row][j+col];
                }
            }
            average /= 9; 
            ret[i][j] = average; 
        }
    }
    
    return ret; 
}

//took <5 minutes
