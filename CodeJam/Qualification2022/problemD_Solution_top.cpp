/*
 My solution is the same as you just invert the pointers so that you can start from the abyss as the root and travel down via a dfs getting you O(N). The difference is that what you need to do is sum up all the children of each root and add that to the total answer (save it) and only overwrite the minimum path, I didn't do that and overwite all of the paths causing the incorrect solution. This solution is a lot more elegant than mine as well. 
 */


#include <bits/stdc++.h>
using namespace std;

int T, N, F[1000005], P[1000005];
vector<int> adjlist[1000005];
long long ans = 0;

long long dfs(int x) {
    if (adjlist[x].size() == 0) return F[x];
    vector<int> childs;
    for (int i = 0; i < adjlist[x].size(); i++) {
        childs.push_back(dfs(adjlist[x][i]));
    }
    sort(childs.begin(), childs.end());
    for (int i = 1; i < childs.size(); i++) {
        ans += childs[i];
    }
    return max(childs[0], F[x]);
}

int main() {
    scanf("%d", &T);
    for (int tc = 1; tc <= T; tc++) {
        scanf("%d", &N);
        for (int i = 0; i < N; i++) scanf("%d", &F[i+1]);
        for (int i = 0; i <= N; i++) adjlist[i].clear();
        for (int i = 0; i < N; i++) {
            scanf("%d", &P[i+1]);
            adjlist[P[i+1]].push_back(i+1);
        }
        ans = 0;
        ans += dfs(0);
        printf("Case #%d: %lld\n", tc, ans);
    }
}
