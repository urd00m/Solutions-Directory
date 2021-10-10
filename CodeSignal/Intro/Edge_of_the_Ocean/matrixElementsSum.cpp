int matrixElementsSum(vector<vector<int>> matrix) {
    //set everything below zero to zero 
    int sum = 0; 
    for(unsigned long i = 0; i < matrix.size();i++) {
        for(unsigned long j = 0; j < matrix[i].size(); j++) {
            
            if(matrix[i][j] == 0) {
                //set everything below it to zero 
                for(unsigned long k = 0; k < matrix.size(); k++) {
                    matrix[k][j] = 0; 
                }
            }
            else {
                sum += matrix[i][j]; 
            }
        }
    }
    return sum; 
}

