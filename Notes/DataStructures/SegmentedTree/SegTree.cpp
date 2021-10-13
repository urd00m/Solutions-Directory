//TODO: implement update function + reading up on how to implement RSQ

#include <vector>
#include <iostream>

using namespace std; 

class SegmentTree { //stored like a heap array 
    private:  
        vector<int> st, A; 
        int n; 
        int left (int p) { return p << 1; } //same as binary heap operations 
        int right(int p) { return (p << 1) + 1; }

        void build(int p, int L, int R) { //O(n)
            if(L == R) // As L == R either one is fine 
                st[p] = L; 
            else { //recursively compute the values 
                build(left(p), L, (L+R)/2); 
                build(right(p), (L+R)/2+1, R); 
                int p1 = st[left(p)], p2 = st[right(p)];
                st[p] = (A[p1] <= A[p2]) ? p1 : p2; 
            }
        }
        //O(log n)
        void update(int p, int L, int R, int idx, int newItem) {
            if(idx >= L && idx <= R && L == R) {
                A[idx] = newItem; 
            }
            else { //recursively compute the values 
                if(idx >= L && idx <= (L+R)/2) update(left(p), L, (L+R)/2, idx, newItem); 
                if(idx <= R && idx >= (L+R)/2+1) update(right(p), (L+R)/2+1, R, idx, newItem); 
                int p1 = st[left(p)], p2 = st[right(p)];
                st[p] = (A[p1] <= A[p2]) ? p1 : p2; 
            }
        }

        int rmq(int p, int L, int R, int i, int j) { // O(log n) 
            if(i > R || j < L) return -1; // Current segment outside of query range 
            if(L >= i && R <= j) return st[p]; //inside query range 

            // compute the min position in the left and right part of the interval 
            int p1 = rmq(left(p), L, (L+R)/2, i, j);
            int p2 = rmq(right(p), (L+R)/2 + 1, R, i, j);

            if(p1 == -1) return p2; //if we try to access segment outside query 
            if(p2 == -1) return p1; // same as above 
            return (A[p1] <= A[p2]) ? p1 : p2; // As in build routine 
        }

    public: 
        SegmentTree(const vector<int> &_A) {
            A = _A; n = (int)A.size();  // copy content for local usage 
            st.assign(4 * n, 0);        // create large enough vector of zereos 
            build(1, 0, n - 1);         // recursive build 
        }
        int rmq(int i , int j) { return rmq(1, 0, n-1, i, j); } //overloading 
        void update(int idx, int newItem) { update(1, 0, n-1, idx, newItem); }
};

// For testing 
int main() {
    int arr[] = {11, 17, 13, 19, 15, 11, 20};
    vector<int> A(arr, arr + 7);
    SegmentTree st(A); 
    cout << "RMQ(0,3) " << st.rmq(0, 3) << endl; 
    cout << "RMQ(4,6) " << st.rmq(4, 6) << endl;
    cout << "RMQ(0,6) " << st.rmq(0, 6) << endl;

    st.update(3, 1); 
    cout << "after update RMQ(0,3) " << st.rmq(0, 3) << endl; 

    cout << "RMQ(0,6) " << st.rmq(0, 6) << endl;
    st.update(6, 0); 

    cout << "after updateRMQ(0,6) " << st.rmq(0, 6) << endl;

}
