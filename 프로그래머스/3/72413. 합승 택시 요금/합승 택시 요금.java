import java.util.*;

class Edge implements Comparable<Edge> {
    int node, cost;
    
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        
        int[] answerS = dijkstra(graph, s);
        int[] answerA = dijkstra(graph, a);
        int[] answerB = dijkstra(graph, b);
        
        for (int i = 1; i <= n; i++) {
            int tmp = answerS[i] + answerA[i] + answerB[i];
            answer = Math.min(tmp, answer);
        }
        return answer;
    }
    
    int[] dijkstra(Map<Integer, List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            
            if (distance[curr.node] < curr.cost) continue;
            
            for (Edge next : graph.get(curr.node)) {
                int nextCost = distance[curr.node] + next.cost;
                
                if (distance[next.node] > nextCost) {
                    pq.add(new Edge(next.node, nextCost));
                    distance[next.node] = nextCost;
                }
            }
        }
        return distance;
    }
}