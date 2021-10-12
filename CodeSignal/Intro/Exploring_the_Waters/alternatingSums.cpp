vector<int> alternatingSums(vector<int> a) {
    vector<int> weights(2, 0); 
    for(long i = 0; i < a.size(); i++) {                    weights[i%2] += a[i];
    }
    return weights; 
}   

