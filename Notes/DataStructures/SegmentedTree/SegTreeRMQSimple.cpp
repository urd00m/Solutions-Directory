//RMQ
#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std; 

const int N = 1e5;  // limit for array size
int n;  // array size
int t[2 * N];

void build() {  // build the tree
  for (int i = n - 1; i > 0; --i) t[i] = min(t[i<<1], t[i<<1|1]); //left and right 
}

//This implementation is just cleaner, you change the value, then the parent is just the minimum of its children 
void modify(int p, int value) {  // set value at position p
  for (t[p += n] = value; p > 1; p >>= 1) t[p>>1] = min(t[p],t[p^1]);
}

void modify2(int p, int value) { //set value at position p (alternative implementation)
  t[p+n] = value; 
  for(int i = (p+n)>>1; i > 0; i >>= 1) t[i] = min(t[i<<1], t[i<<1|1]); //left and right child 
}

//complicated proof can't replicate it, memorize 
int query(int l, int r) {  // min on interval [l, r)
  int res = INT32_MAX;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l&1) res = min(t[l++], res);
    if (r&1) res = min(t[--r], res);
  }
  return res;
}

int main() {
  int input[] = {1,2,3,4,5,6,7,8,9};
  n = 9;
  //scanf("%d", &n);
  for (int i = 0; i < n; ++i) *(t + n + i) = input[i]; 
  //for (int i = 0; i < n; ++i) scanf("%d", t + n + i);
  build();
  modify2(0, 10);
  std::cout << query(3, 11) << std::endl; //should be 4 now 
  std::cout << query(0, 2) << std::endl; //should be 2
  std::cout << query(5, 9) << std::endl;  //should be 6
  return 0;
}

