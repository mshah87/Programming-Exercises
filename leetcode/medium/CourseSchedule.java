class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sort cycle finding on directed graph: O(V+E) time complexity, O(V+E) space
        if(prerequisites == null || prerequisites.length == 0 || numCourses == 0){
            return true;
        }
        
        // set up adj list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        
        for(int[] prereq: prerequisites){
            map.get(prereq[1]).add(prereq[0]); // directed graph, [1,0], 0->1
        }
        
        // create visited array: 0=unvisited, -1= currently visiting, 1 = visited
        int[] visited = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(!dfs(map, visited, i)){ // cycle found
                return false;
            }                
        }
        return true; // no cycle
    }
    
    public boolean dfs(HashMap<Integer, List<Integer>> map, int[] visited, int i){
        if(visited[i] == -1){ // if we run into node that we saw earlier in CURRENT dfs, it's a cycle
            return false; 
        }
        
        if(visited[i] == 1) { // if we run into node that we saw in separate earlier dfs, no problem
            return true; 
        }
        
        visited[i] = -1; // mark current node as -1, currently visiting
        if(map.containsKey(i)) {
            for(int j: map.get(i)) { // visit all neighbours of i
                if(!dfs(map, visited, j)) { // dfs into its neighbours and return false if cycle found
                    return false;  
                } 
            }
        }
        
        visited[i] = 1; // if all neighbours visited and no problems, we're done with this node and mark it as 1, done visiting
        
        return true;
    }
}
