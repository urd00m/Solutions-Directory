//RSQ
#include <iostream>

const int N = 1e5;  // limit for array size
int n;  // array size
int t[2 * N];

void build() {  // build the tree
  for (int i = n - 1; i > 0; --i) t[i] = t[i<<1] + t[i<<1|1]; //left and right 
}

void modify(int p, int value) {  // set value at position p
  for (t[p += n] = value; p > 1; p >>= 1) t[p>>1] = t[p] + t[p^1];
}

int query(int l, int r) {  // sum on interval [l, r)
  int res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l&1) res += t[l++];
    if (r&1) res += t[--r];
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
  modify(0, 10); //should be 49
  std::cout << query(3, 11) << std::endl; 
  return 0;
}
