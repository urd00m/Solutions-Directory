class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        // k-1 dividers 
        // n, k -> n-1 choose k-1 --> too large 
        // dp? too large n*k
        // divide and conquer? no easy way to split 
        // pq --> ad too look up hint ad hoc problem 
        size_t n = weights.size(); 

        // precalc max
        // include every i, i+1 sum 
        // this will include paths that include i, to j where i == j
        priority_queue<long long> pr; 
        for(size_t i = 0; i < n-1; i++) 
            pr.push(weights[i] + weights[i+1]); 

        // calc max 
        long long sr = weights[0] + weights[n-1]; 
        for(int i = 0; i < k-1; i++) {
            sr += pr.top(); pr.pop(); 
        }

        // precalc min 
        // this could be made to be twice as fast 
        priority_queue<long long, vector<long long>, greater<long long>> pl;
        for(size_t i = 0; i < n-1; i++) 
            pl.push(weights[i] + weights[i+1]); 

        // calc min
        long long sl = weights[0] + weights[n-1]; 
        for(int i = 0; i < k-1; i++) {
            sl += pl.top(); pl.pop(); 
        }
        return sr - sl; 
    }
};
