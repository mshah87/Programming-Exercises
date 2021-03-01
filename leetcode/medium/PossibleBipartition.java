class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) { // graph coloring problem: O(V+E) time, O(V+E) space
        // make adj list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for(int[] dislikePair: dislikes){
            map.get(dislikePair[0] -1).add(dislikePair[1] -1);
            map.get(dislikePair[1] -1 ).add(dislikePair[0]-1);
        }
        
        // create visited array, 0=unvisited, 1=group A, -1=group B
        int[] visited = new int[N];
        for(int i = 0; i<N; i++){
            if(visited[i] == 0 && !dfs(map, visited, i, 1)){
                return false; // if dfs finds two neighbours in same group
            }
        }
        return true;
    }
    
    public boolean dfs( HashMap<Integer, List<Integer>> map, int[] visited, int person, int group){
        visited[person] = group; // put this person in a group/color
        
        for(int j: map.get(person)){ // get all neighbours of this person/node
            if(visited[j] == group) {
                return false; // if those neighbours belong to same group... problem
            }
            // if neighbour not visited yet, dfs into it and assign opposite group 
            if(visited[j] == 0 && !dfs(map, visited, j, -group)){
                return false;
            }
   
            // no issues, skip if statements
        }
        return true; // dfs didn't run into any issues with neighbours, we're good
    }
}
