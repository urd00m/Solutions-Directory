int dpq(vector < vector < pair < int, int >>> & graph, int n) {
  vector < int > dist(n, 1000000000);
  priority_queue < pair < int, int > , vector < pair < int, int >> , greater < pair < int, int >> > pq;
  pq.push(make_pair(0, 0));
  dist[0] = 0;
  while (pq.empty() == false) {
    pair cur = pq.top();
    pq.pop();
    int d = cur.first, u = cur.second;
    if (d > dist[u]) continue;
    for (int j = 0; j < (int) graph[u].size(); j++) {
      pair v = graph[u][j];
      if (dist[u] + v.second < dist[v.first]) {
        dist[v.first] = dist[u] + v.second;
        pq.push(make_pair(dist[v.first], v.first));
      }
    }
  }
  return dist[n - 1];
}
