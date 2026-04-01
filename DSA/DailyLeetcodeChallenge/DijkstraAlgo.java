import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstraAlgo {
    // Pair class to store (node, distance)
   /*  static class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // Build Adjacency List
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        // Undirected graph
        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; //always src to src dist is 0
        
        // Min-Heap (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.dist, b.dist)
            );
        
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;
            
            // Skip, if already found a better path
            if(d > dist[node]) continue;
            
            // Relax neighbours
            for(Pair neigh : adj.get(node)){
                int newDist = d + neigh.dist;
                
                if(newDist < dist[neigh.node]){
                    dist[neigh.node] = newDist;
                    pq.add(new Pair(neigh.node, newDist));
                }
            }
        }
        return dist;
    } */
   // Pair class to store (node, distance)
    static class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // Build Adjacency List
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        // Undirected graph
        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; //always src to src dist is 0
        
         // TreeSet (ordered by distance, then node)
        TreeSet<Pair> set = new TreeSet<>(
            (a, b) -> {
                if (a.dist == b.dist) return a.node - b.node;
                return a.dist - b.dist;
            }
        );
        
        set.add(new Pair(src, 0));
        
        while(!set.isEmpty()){
            Pair curr = set.pollFirst(); // smallest distance
            int node = curr.node;
            int d = curr.dist;
            
            for(Pair neigh : adj.get(node)){
                int newDist = d + neigh.dist;
                
                if(newDist < dist[neigh.node]){
                    // Remove old pair if exists
                    if(dist[neigh.node] != Integer.MAX_VALUE){
                        set.remove(new Pair(neigh.node, dist[neigh.node]));
                    }
                    dist[neigh.node] = newDist;
                    set.add(new Pair(neigh.node, newDist));
                }
            }
    }
     return dist;
}
        public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
            {0, 1, 1},
            {1, 2, 3},
            {0, 2, 6}
        };
        int src = 2;
        int[] distances = dijkstra(V, edges, src);
        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(distances)); // Output: [4, 3, 0]
    }
}