package DataStructures.Graphs.Algorithms.Path;

import java.util.*;

class DijkstrasProblems{


  // https://leetcode.com/problems/network-delay-time/
  class Edge{
    int node, time;
    Edge(int node, int time){
        this.node = node; this.time = time;
    }
  }
  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<Edge>> adj = new ArrayList<>();
    int[] delay = new int[n+1];
    Arrays.fill(delay, Integer.MAX_VALUE);
    for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
    for(int[] time : times){
        int u = time[0], v = time[1], w = time[2];
        adj.get(u).add(new Edge(v, w));
    }
    PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->{
        return e1.time - e2.time;
    });
    pq.offer(new Edge(k, 0));
    delay[k] = 0;
    while(!pq.isEmpty()){
        Edge curr = pq.poll(); int node = curr.node; int time = curr.time;

        for(Edge next : adj.get(node)){
            int nextNode = next.node; int future = next.time;
            if(delay[nextNode] > future + time){
                delay[nextNode] = future + time;
                pq.offer(new Edge(nextNode, delay[nextNode]));
            }
        }
    }
    int min = Integer.MIN_VALUE;
    for(int i = 1; i <= n; i++){
        if(delay[i] == Integer.MAX_VALUE) return -1;
        min = Math.max(min, delay[i]);
    }
    return min;
  }
  
  // https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
  public int countPaths(int n, int[][] roads) {
    int MOD = 1_000_000_007;

    // Build the graph: each list holds pairs (neighbor, travelTime)
    List<List<Pair>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    for (int[] road : roads) {
        int u = road[0], v = road[1], t = road[2];
        graph.get(u).add(new Pair(v, t));
        graph.get(v).add(new Pair(u, t));
    }

    // Initialize distances and ways arrays.
    long[] dist = new long[n];
    int[] ways = new int[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[0] = 0;
    ways[0] = 1;

    // Priority queue for Dijkstra: (node, current distance)
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
    pq.offer(new Pair(0, 0));

    while (!pq.isEmpty()){
        Pair cur = pq.poll();
        int node = cur.node;
        long currTime = cur.time;

        // Skip if we have already found a shorter path to this node
        if (currTime > dist[node]) continue;

        // Check all neighbors of current node
        for (Pair neighbor : graph.get(node)) {
            int nextNode = neighbor.node;
            long newTime = currTime + neighbor.time;

            // Found a shorter path to nextNode
            if (newTime < dist[nextNode]) {
                dist[nextNode] = newTime;
                ways[nextNode] = ways[node];
                pq.offer(new Pair(nextNode, newTime));
            }
            // Found an alternative path that is equally short
            else if (newTime == dist[nextNode]) {
                ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
            }
        }
    }
    return ways[n - 1];
  }

  class Pair {
    int node;
    long time;
    public Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
  }


  // https://leetcode.com/problems/cheapest-flights-within-k-stops/
  class Info {
    int stops, node, distance;
    Info(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
  }
  // do not apply dijkstra's algorithm here, because we need to consider the number of stops
  // queue is enough to solve this problem as stops are inserted in increasing order
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] flight : flights) {
        adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
    }

    Queue<Info> q = new LinkedList<>();
    q.offer(new Info(0, src, 0));
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    // BFS
    // O(n + e)
    while (!q.isEmpty()) {
        Info info = q.poll();
        if (info.stops > k) continue;
        for (int[] neighbor : adj.get(info.node)) {
            int nextNode = neighbor[0], price = neighbor[1];
            int newDist = info.distance + price;
            if (newDist < dist[nextNode]) {
                dist[nextNode] = newDist;
                q.offer(new Info(info.stops + 1, nextNode, newDist));
            }
        }
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
  }
}