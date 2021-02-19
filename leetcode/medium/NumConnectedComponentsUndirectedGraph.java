import java.util.Arrays;
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

// Example 1:
//     0          3
//     |          |
//     1 --- 2    4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

// Example 2:
//     0           4
//     |           |
//     1 --- 2 --- 3
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

// Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

// Union find: O(N+M*log(N)) complexity where M = # edges given and N = # nodes we have (parents array)
// space: O(N): parents array
class Solution { 
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1); // initially set every node parent to -1 

        for(int[] edge: edges){
            union(parents, edge[0], edge[1]); // merge edges
        }

        int count = 0;
        for(int i = 0; i<parents.length; i++){
            if(parents[i] == -1) count++;
        }
        return count;
    }

    public void union(int[] parents, int edge1, int edge2){
        int parent1 = find(parents, edge1);
        int parent2 = find(parents, edge2);
        if(parent1 != parent2){
            parents[parent1] = parent2; // set parent1 to parent2, successfully merged
        }
    }

    public int find(int[] parents, int edge){
        if(parents[edge] != -1){ // if the current edge parent is not -1, 
            return find(parents, parents[edge]); // path compression, recursively smooth out edges 
        }
        return edge;
    }
}


// DFS: O(V+E): slightly slower since we have to make the adj list
class Solution { 
    public int countComponents(int n, int[][] edges) {
        // set up adj list
        HashMap<Integer, List<Integer>> adj = new HashMap<>(); // key is the edge and value is its neighbours
        for(int i = 0; i<n; i++){
            adj.put(i, new LinkedList<Integer>()); // initialize empty neighbour list 
        }

        for(int i = 0; i<edges.length; i++){ // populate adj list with all nodes neighbours, do it twice since its undirected
            adj.get(edges[i][0].add(edges[i][1]));
            adj.get(edges[i][1].add(edges[i][0]));
        }

        boolean[] visited = new boolean[n]; // visited array, false = unvisited, true = visited
        int count = 0; // # of connected components
        for(int i = 0; i<n; i++){
            if(visited[i] == false){ // if we encouter unvisited node, increment count and dfs to find its neighbours
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }

    public void dfs(HashMap<Integer, List<Integer>> adj, int node, boolean[] visited){
        visited[node] = true; // mark current node as visited

        // get all neighbours of this node
        for(Integer i: adj.get(node)){
            if(visited[i] == false){ // if we haven't visited this neighbour, dfs into it
                dfs(adj, i, visited);
            }
        }
    }
}
